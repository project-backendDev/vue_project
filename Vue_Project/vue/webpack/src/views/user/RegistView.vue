<template>
    <form @submit.prevent="joinForm">

        <h1>회원가입</h1>
        <div>
            <label>
                아이디
                <br />
                <input type="text" v-model="userId" autofocus />
            </label>
        </div>
        
        <div>
            <label>
                비밀번호
                <br />
                <!-- @input >> 사용자가 입력할 때 마다 검증 메소드를 호출 -->
                <input type="password" v-model="userPw" @input="validUserPw"  placeholder="PASSWORD" />
                <div>
                    <span v-if="passwordError">{{ passwordError }}</span>
                </div>
            </label>
        </div>

        <div>
            <label>
                비밀번호 확인
                <br />
                <input type="password" id="userPwRe" @input="userPwMatch" placeholder="PASSWORD" />
                <div>
                    <span v-if="passwordNotMatch"> {{ passwordNotMatch }}</span>
                </div>
            </label>
        </div>

        <div>
            <label>
                이름
                <br />
                <input type="text" v-model="name" />
            </label>
        </div>

        <div>
            <label>
                전화번호
                <br />
                <input type="text" v-model="tel" />
            </label>
        </div>

        <div>
            <label>
                생일
                <br />
                <input type="text" v-model="birthday" />
            </label>
        </div>

        <div>
            <label>
                성별
                <br />
                <input type="text" v-model="gender" />
            </label>
        </div>

        <div>
            <label>
                우편번호
                <br />
                <input type="text" v-model="postcode" />
            </label>
        </div>

        <div>
            <label>
                주소
                <br />
                <input type="text" v-model="addr1" />
            </label>
        </div>

        <div>
            <label>
                상세주소
                <br />
                <input type="text" v-model="addr2" />
            </label>
        </div>
        
        <div>
            <button type="submit">가입</button>
        </div>
    </form>
    <button @click="cancel()">취소</button>
</template>

<script>
    import axios from 'axios';

    export default {
        data() {
            return {
                userInfo: {
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
                },
                passwordError : '',
                passwordNotMatch : '',

            };
        },
        computed : {
            isFormValid() {
                return this.validUserPw || this.userPwMatch;
            },
        },
        methods : {
            validUserPw() {
                const regEx = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;

                if (!regEx.test(this.userPw)) {
                    this.passwordError = '비밀번호는 최소 8자 이상, 대문자, 소문자, 숫자, 특수 문자를 포함해야 합니다.';
                } else {
                    this.passwordError = '';
                }
            },
            userPwMatch() {
                const passRe = document.getElementById("userPwRe").value;
                const pass = this.userPw;
                console.log("[1]    " + passRe);

                if (passRe != pass) {
                    this.passwordNotMatch = '입력하신 비밀번호와 일치하지 않습니다.';
                } else {
                    this.passwordNotMatch = '';
                }
            },
            joinForm() {
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

                axios.post('http://localhost:8095/api/user/regist', requestData)
                    .then(response => {
                        alert(response.data);   //  회원가입이 완료되었습니다.
                        this.$router.push('/');
                    })
                    .catch(error => {
                        alert("회원가입에 실패하였습니다.\n 동일 오류가 발생할 경우 관리자에게 문의하세요.");
                        console.log(error);
                        return false;
                    })
            },
            cancel() {
                const con = "회원가입을 취소하시겠습니까?";

                if (confirm(con)) {
                    this.$router.push('/');
                } else {
                    return false;
                }
            }
        }
    }
</script>