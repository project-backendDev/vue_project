const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  // npm run build 빌드 시 파일이 생성되는 위치
  outputDir:"../../src/main/resources/static",
  // 
  devServer:{
    // 사용할 포트 (default : 8080)
    port: 8080, 
    // API 요청을 다른 서버로 프록시 할 수 있도록 설정
    proxy:  {
      '/api' : {
        target : 'http://localhost:8095',
        changeOrigin : true
      }
    },
    // proxy: 'http://localhost:8095',
    
    // 코드 변경사항을 새로 고침없이 즉시 반영 (default : false)
    hot : true,
    
    // 접근 가능 IP (default : localhost, 아무나 접근 가능 -> 0.0.0.0)
    // host : '0.0.0.0', 

    // HTTPS 사용여부 (default : false)
    // https: true, 

    // 서버 시작 시 브라우저를 자동으로 여는 여부 (default : false)
    // open : true,

    // 컴파일 오류나 경고를 브라우저에 오버레이로 표시할지 여부를 설정 (default : false)
    // overlay : true,

    // 파일 변경 감지 옵션을 설정 (변경 감지 지연 시간 or 폴링 옵션)
    // watchOptions: {
    //  poll: 1000, // 1초마다 폴링
    //  aggregateTimeout: 300 // 변경 후 300ms 대기
    //}
  //   disableHostCheck: true
  },
});