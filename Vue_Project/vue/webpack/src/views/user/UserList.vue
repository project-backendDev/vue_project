<template>
    <div>
        전체 회원 리스트
    </div>

    <div v-for="user in userList" :key="user.userId">
        <ul>
            <li>
                <router-link :to="`/user/${user.userId}`">
                    {{ user.userId }}
                </router-link>
                <!--
                <router-link :to="{ name: 'userDetail', params: { userId: user.userId } }">
                    {{ user.userId }}
                </router-link>
                -->
                <br />
                {{ user.tel }}
            </li>
        </ul>
    </div>

</template>

<script>
    import axios from 'axios';

    export default {
        data() {
            return {
                userList : {},
            };
        },
        created() {
            this.getUserList();
        },
		methods: {
			getUserList() {
                axios.get('http://localhost:8095/api/user/getUserList')
                    .then(response => {
                        this.userList = response.data;
                        console.log(response.data);
                    })
                    .catch(error => {
                        console.log("Error!!", error);
                    })
            }
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