import { createApp } from 'vue'
import App from './App.vue'
import router from './router' // <-- 설치한 라우터를 가져와서

createApp(App).use(router).mount('#app') // <-- 사용할 것이라고 선언
