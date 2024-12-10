const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  outputDir:"../../src/main/resources/static",
  devServer: {
	port : 8080,
	proxy: {
		'/api': {
			target: 'http://localhost:8095',
			changeOrigin: true
			}
		}
	}
  
  // devServer:{
  //   prot: 8081,
  //   proxy:  'http://localhost:8080',
  //   disableHostCheck: true
  // },
});