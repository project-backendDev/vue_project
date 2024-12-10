<template>
  <div>
    <h2>회원가입</h2>
    <form @submit.prevent="registerUser">
      <div>
        <label for="username">아이디:</label>
        <input type="text" v-model="userId" required />
      </div>
      <div>
        <label for="password">비밀번호:</label>
        <input type="password" v-model="userPw" required />
      </div>
	  <div>
	    <label for="password">이름:</label>
	    <input type="password" v-model="name" required />
	  </div>
	  <div>
	    <label for="password">전화번호:</label>
	    <input type="password" v-model="tel" required />
	  </div>
      <button type="submit">가입하기</button>
    </form>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      username: '',
      password: ''
    };
  },
  methods: {
    async registerUser() {
      try {
        const response = await axios.post('http://localhost:8095/api/user/regist', {
          username: this.username,
          password: this.password
        });
        alert('회원가입 성공: ' + response.data.username);
      } catch (error) {
        console.error('회원가입 실패:', error);
        alert('회원가입 실패');
      }
    }
  }
};
</script>