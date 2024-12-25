<template>
    <div>
        회원 상세정보
    </div>

    <div>
        <ul>
            <li>
                <span>
                    아이디
                </span>
                <span>
                    <router-link :to="`/user/updateView/${userDetail.userId}`">
                            {{ userDetail.userId }}
                    </router-link>
                </span>
            </li>
            <li>
                <span>
                    이름
                </span>
                <span>
                    {{ userDetail.name }}
                </span>
            </li>
            <li>
                <span>
                    연락처
                </span>
                <span>
                    {{ userDetail.tel }}
                </span>
            </li>
            <li>
                <span>
                    생년월일
                </span>
                <span>
                    {{ userDetail.birthday }}
                </span>
            </li>
            <li>
                <span>
                    성별
                </span>
                <span>
                    {{ userDetail.gender }}
                </span>
            </li>
            <li>
                <span>
                    주소
                </span>
                <br />
                <span>
                    우편번호 : {{ userDetail.postcode }}
                </span>
                <br />
                <span>
                    상세주소 : {{ userDetail.addr1 }} {{ userDetail.addr2 }}
                </span>
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