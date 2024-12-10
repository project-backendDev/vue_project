<template>
  	<img alt="Vue logo" src="./assets/logo.png">
  	<HelloWorld msg="Welcome to Your Vue.js App"/>
  	<div id="app">
		<nav>
			<router-link to="/">홈</router-link>
			<router-link to="/registView">회원가입</router-link>
		</nav>
		<router-view></router-view>
	</div>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'
import registView from './components/registView.vue'

export default {
  name: 'App',
  components: {
    HelloWorld,
	registView
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
