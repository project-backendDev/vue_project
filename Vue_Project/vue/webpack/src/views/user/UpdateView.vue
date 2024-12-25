<template>
    <div>
        <h1>
            회원수정페이지
        </h1>
    </div>

    <form @submit.prevent="updtForm">
        <input type="hidden" name="userType" v-model="user.userType" />
        <input type="hidden" name="loginType" v-model="user.loginType" />
        <input type="hidden" name="editDate" />
        <div>
            <ul>
                <li>
                    <span>
                        아이디
                    </span>
                    <span>
                        {{ user.userId }}
                    </span>
                </li>
                <li>
                    <span>
                        이름
                    </span>
                    <span>
                        <input type="text" name="name" v-model="user.name" />
                    </span>
                </li>
                <li>
                    <span>
                        연락처
                    </span>
                    <span>
                        <input type="text" name="tel" v-model="user.tel" />
                    </span>
                </li>
                <li>
                    <span>
                        생년월일
                    </span>
                    <span>
                        <input type="date" name="birthday" v-model="user.birthday" />
                    </span>
                </li>
                <li>
                    <span>
                        성별
                    </span>
                    <span>
                        <input type="text" name="gender" v-model="user.gender" />
                    </span>
                </li>
                <li>
                    <span>
                        주소
                    </span>
                    <br />
                    <span>
                        우편번호 : <input type="text" name="postcode" v-model="user.postcode" />
                        <button type="button" @click="openDaumPop()">주소찾기</button>
                    </span>
                    <br />
                    <span>
                        상세주소 : <input type="text" name="addr1" v-model="user.addr1" /><input type="text" name="addr2" v-model="user.addr2" />
                    </span>
                </li>
            </ul>
        </div>
        <div>
            <button type="submit">수정</button>
            <button @click="cancel()">취소</button>
        </div>
    </form>
</template>
<script>
    import axios from 'axios';

    export default {
        data() {
            return {
                user : {
                    userId : '',
                    userPw : '',
                    name : '',
                    tel : '',
                    birthday : '',
                    gender : '',
                    postcode : '',
                    addr1 : '',
                    addr2 : '',
                    userType : '',
                    loginType : ''
                }
            };
        },
        created() {
            this.getUser();
        },
        methods : {
            // 주소찾기 버튼 클릭 시 다음 우편번호 API 호출
            openDaumPop() {
                new window.daum.Postcode({
                    oncomplete: (data) => {
                        this.postcode = data.zonecode;
                        this.addr1 = data.address;
                    }
                }).open()
            },
            // 페이지 접속 시 유저 데이터를 가져오는 메소드 (created() 부분에서 사용)
            getUser() {
                const userId = this.$route.params.userId;
                axios.get(`http://localhost:8095/api/user/${userId}`)
                        .then(response => {
                            this.user = response.data;
                            console.log(response.data);
                        })
                        .catch(error => {
                            console.log("Error!!", error);
                        })
            },
            // 수정버튼 클릭 시 동작
            updtForm() {
                let requestData = {
                    userId    : this.userId,
                    userPw    : this.userPw,
                    name      : this.name,
                    tel       : this.tel,
                    birthday  : this.birthday,
                    gender    : this.gender,
                    postcode  : this.postcode,
                    addr1     : this.addr1,
                    addr2     : this.addr2,
                    userType  : 'normal',
                    loginType : 'site'
                };
                console.log(requestData);
            },
            // 취소 버튼 클릭 시
            cancel() {
                const con = "정보수정을 취소하시겠습니까?";

                if (confirm(con)) {
                    this.$router.go(-1);
                } else {
                    return false;
                }
            }
        }
    }
</script>