<template>
    <div>
        회원 상세정보
    </div>

    <div>
        <ul>
            <li>
                {{ userDetail.userId }}
                <!--
                <router-link :to="{ name: 'userDetail', params: { userId: user.userId } }">
                    {{ user.userId }}
                </router-link>
                -->
                <br />
                {{ userDetail.tel }}
            </li>
        </ul>
    </div>

</template>

<script>
    import axios from 'axios';

    export default {
        data() {
            return {
                userDetail : []
            };
        },
        created() {
            const userId = this.$route.params.userId;
            console.log("Id     ::  " + this.$route.params.userId);
            axios.get(`http://localhost:8095/api/user/${userId}`)
                    .then(response => {
                        this.userDetail = response.data;
                        console.log(response.data);
                    })
                    .catch(error => {
                        console.log("Error!!", error);
                    })
        }
    };


    /*
    export default {
        data() {
            return {
                userList : []
            };
        },
        methods : {
            fetchUsers() {
                try {
                    const response = axios.get('http://localhost:8095/api/user/getUserList');
                    this.userList = response.data;
                    console.log(response.data);
                } catch (error) {
                    console.log("Error!!", error);
                }
            }
        }
    };
    */
</script>