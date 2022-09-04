export default{
    state: {
        needUpload:false,
        
    },
    mutations: {
        toUpload:function(state){
           if(sessionStorage.musicLogin){
            state.needUpload=true
           }else{
            alert("请先登录!")
            this.commit('toLogin',{}, {root: true})
             
           }
        }
    },
    actions: {
    },
    
}