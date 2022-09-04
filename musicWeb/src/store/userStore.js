export default{
    state: {
        needLog:false,
        isLog:false,
        switchRL:false,
        loginName:""
      },
      mutations: {
        //需要登录时设置登录用于调出登录注册框
        toLogin:function(state){
          state.needLog = true
        },
        //退出登录时清空musicLogin
        outLogin:function(state){
          sessionStorage.removeItem('musicLogin'),
          state.isLog=false
          // this.$router.push('/')
          location.reload()
        
        },
        //改变登录状态
        changeLoginState:function(state,tf){
          if(tf==true&&sessionStorage.musicLogin){
            state.loginName=sessionStorage.getItem('musicLogin')
            state.isLog=tf
          }
          state.isLog=tf
         
        },
        
        //AppHeader获取登录名
        getLoginName:function(state){
     
          if(sessionStorage.musicLogin){
          state.loginName=sessionStorage.getItem('musicLogin')
          state.isLog=true
        
          }
        },
        changeSwitch(state,alt) {
          if (alt == "reg") {
            state.switchRL = true;
          } else if (alt == "log") {
            state.switchRL = false;
          }
        },
      },
}