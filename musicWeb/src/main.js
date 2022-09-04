import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import axios from 'axios'
import qs from 'qs'
import Element from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import 'font-awesome/css/font-awesome.css'
axios.defaults.baseURL="http://localhost:8090/musicApi"
axios.defaults.timeout="3000"
//其他axios全局配置选项…
Vue.prototype.$axios=axios
Vue.prototype.$qs=qs
Vue.use(Element)
Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
