import Vue from 'vue'
import VueRouter from 'vue-router'
import Main from '../views/Main.vue'
import store from '../store/index.js';
Vue.use(VueRouter)
const originalPush = VueRouter.prototype.push;
VueRouter.prototype.push = function push(location) {
  return originalPush.call(this, location).catch(err => err)
}
const routes = [
  {
    path: '/',
    name: 'Main',
    component: Main,
  
  },
  
  {
    path: '/myMusic',
    name: 'My',
    component:()=> import('../views/MyMusic.vue'),
    
  },
  {
    path: '/search',
    name: 'Search',
    component:()=> import('../views/Search.vue'),
    
  },
  
]

const router = new VueRouter({
  routes
})
router.beforeEach( function(to,from,next){
  if(to.path=='/myMusic'){
    if(sessionStorage.musicLogin!=null){
      next()
    }else{
        alert("请登录")
       store.commit('toLogin')
    }
  }else{
    next()
  }

})

export default router
