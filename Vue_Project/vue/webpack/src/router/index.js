import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '@/views/HomeView.vue'
import About from '@/views/AboutView.vue'
import RegistView from '@/views/user/RegistView.vue'


/*
	component 작성 방법 차이(직접 vs 함수)
	처음에 component에 직접 쓰는 법과 함수형으로 쓰는게 어떻게 다른지가 궁금해서 찾아보게 되었는데 
	첫번째는 각각의 컴포넌트를 직접 참조하여 component 속성에 할당하는 것이고, 
	두번째는 함수를 사용하여 component 속성에 할당하는 방법으로 동적 import를 통해 작성한 경로에 있는 파일을 비동기적으로 불러오는 역할을 수행한다고 한다.
	결론적으로, 첫번째 예제는 라우트 설정 시 이미 import 되어 있는 컴포넌트를 할당하는 반면, 
	두번째 예제는 동적 import를 통해 비동기적으로 불러오는 방식으로 사용된 것이다. 두가지 방법 중에 두번째 방법을 사용할 경우 초기 렌더링 성능 및 애플리케이션의 로딩 속도를 개선할 수 있다는 장점이 있다. 불필요한 컴포넌트 로딩을 최소화하여 초기 로딩 속도를 빠르게 하고, 필요한 시점에 필요한 컴포넌트를 로딩하여 성능을 최적화시킬 수 있기 때문이다.
	초기 렌더링 성능 및 애플리케이션의 로딩 속도를 개선하고자 할 때는 동적 import를 통해 파일을 비동기적으로 불러오는 방식을 
	사용하는 것이 좋기 때문에 두번째 방식을 사용하는 것이 좋을 것 같다.
*/

// 라우트 정의
const routes = [
  {
    path: '/', 			// 기본 경로
    name: 'home',		// 라우트 이름
    component: HomeView // 해당 경로에 렌더링 할 컴포넌트
	// component : () => import('@/views/HomeView.vue')
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: About
	// component : () => import('@/views/AboutView.vue')
  },
  {
    path : '/registView',
    name : "registView",
    component: RegistView
	// component : () => import('@/views/user/RegistView.vue')
  }
]

// 라우터 인스턴스 생성
const router = createRouter({
  //
  history: createWebHistory('/'),
  routes // 정의한 라우트 배열
})

// 라우트 인스턴스 내보내기
export default router
