<template>
    <form @submit.prevent="joinForm">

        <h1>회원가입</h1>
        <div>
            <label>
                아이디
                <br />
                <input type="text" id="userId" v-model="userId" autofocus placeholder="아이디를 입력해주세요"/>
            </label>
        </div>
        
        <div>
            <label>
                비밀번호
                <br />
                <!-- @input >> 사용자가 입력할 때 마다 검증 메소드를 호출 -->
                <input type="password" id="userPw" v-model="userPw" @input="validUserPw"  placeholder="비밀번호를 입력해주세요" />
                <div>
                    <span v-if="passwordError">
                        {{ passwordError }}
                    </span>
                </div>
            </label>
        </div>

        <div>
            <label>
                비밀번호 확인
                <br />
                <input type="password" id="userPwRe" @input="userPwMatch" placeholder="비밀번호를 다시 한번 입력해주세요" />
                <div>
                    <span v-if="passwordNotMatch">
                        {{ passwordNotMatch }}
                    </span>
                </div>
            </label>
        </div>

        <div>
            <label>
                이름
                <br />
                <input type="text" id="name" v-model="name" />
            </label>
        </div>

        <div>
            <label>
                휴대폰
                <br />
                <input type="text" id="tel" v-model="tel" @input="validUserTel" placeholder="010-1234-5678"/>
                <div>
                    <span v-if="telError">
                        {{ telError }}
                    </span>
                </div>
            </label>
        </div>

        <div>
            <label>
                생일
                <br />
                <input type="date" id="birthday" v-model="birthday" />
            </label>
        </div>

        <div>
            <span>
                성별
            </span>
            <label for="male">
                <input type="radio" id="male" name="gender" v-model="gender" value="male" />남성
            </label>
            <label for="female">
                <input type="radio" id="female" name="gender" v-model="gender" value="female" />여성
            </label>
        </div>

        <div>
            <label for="postcode">우편번호</label>
            <br />
            <input type="text" name="postcode" v-model="postcode" />
            <button type="button" @click="openDaumPop()">주소찾기</button>
            <!-- <input type="text" name="postcode" v-model="postcode"/> -->
        </div>

        <div>
            <label for="addr1">주소</label>
            <br />
            <input type="text" name="addr1" v-model="addr1" />
        </div>

        <div>
            <label for="addr2">상세주소</label>
            <br />
            <input type="text" name="addr2" v-model="addr2" />
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
                // 비밀번호 정규식 체크
                passwordError : '',
                // 비밀번호 체크
                passwordNotMatch : '',
                // 전화번호 정규식 체크
                telError : '',
                // 다음 우편주소 return 데이터
                postcode : '',
                addr1 : '',
            };
        },
        computed : {
            isFormValid() {
                return this.validUserPw || this.userPwMatch || this.validUserTel;
            },
        },
        methods : {
            // 비밀번호 입력 유효성 검사
            validUserPw() {
                const passWordRegEx = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;

                if (!this.userPw || !passWordRegEx.test(this.userPw)) {
                    this.passwordError = '비밀번호는 최소 8자 이상, 대문자, 소문자, 숫자, 특수 문자를 포함해야 합니다.';
                } else {
                    this.passwordError = '';
                }
            },
            // 입력한 비밀번호와 재입력하는 비밀번호가 동일하는지 확인
            userPwMatch() {
                const passRe = document.getElementById("userPwRe").value;
                const pass = this.userPw;

                if (passRe != pass) {
                    this.passwordNotMatch = '입력하신 비밀번호와 일치하지 않습니다.';
                } else {
                    this.passwordNotMatch = '';
                }
            },
            // 전화번호 입력 유효성 검사
            validUserTel() {
                const telRegEx = /^01[0-9]-[0-9]{4}-[0-9]{4}$/;
                
                if (!this.tel || !telRegEx.test(this.tel)) {
                    this.telError = "유효한 핸드폰 번호를 입력해주세요.";
                } else {
                    this.telError = '';
                }
            },
            // 주소찾기 버튼 클릭 시 다음 우편번호 API 호출
            openDaumPop() {
                console.log("여기?");
                new window.daum.Postcode({
                    oncomplete: (data) => {
                        console.log("여긴 왜 안와..?");
                        this.postcode = data.zonecode;
                        this.addr1 = data.address;
                    }
                }).open()
            },
            // 유효성 검사
            validate() {
                const passWordRegEx = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
                const telRegEx = /^01[0-9]-[0-9]{4}-[0-9]{4}$/;

                if (!this.userPw || !passWordRegEx.test(this.userPw)) {
                    alert("유효한 비밀번호를 입력해주세요.");
                    document.getElementById("userPw").focus();
                    return false;
                }

                if (!this.tel || !telRegEx.test(this.tel)) {
                    alert("유효한 핸드폰 번호를 입력해주세요.");
                    document.getElementById("tel").focus();
                    return false;
                }
            },
            // 가입 버튼 클릭 시 동작
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

                // 유효성 검사를 통과하면 회원가입 진행
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
            // 취소 버튼 클릭 시
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