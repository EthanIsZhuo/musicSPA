import axios from 'axios'
export default{
    state: {
        myMusic:[],
        myMusicNum:"",

    },
    mutations: {
          //音乐收藏：LoveState 代表收藏或者取消收藏的状态
        changeLoveState:function(state,id){  
             
              var _this=this
              axios({
                  
                  url:'/ILoveMusic',
                  method:'get',
                  params:{'userName':sessionStorage.getItem('musicLogin'),musicId:id}
                 }).then(function (resp) {
                  if(resp){
                      alert(resp.data)
                      _this.commit('getMyMusic')
                  }
                 
                
                   
             })
             .catch(function (err) {//测试网络异常(关闭后端服务器)
               
               _this.err = "发生错误，原因是:" + err.message;
                                                                      
             });
        },
        //获得私人歌单
        getMyMusic:function(state){
           var _this=this
           axios({
               
               url:'/myMusicServlet',
               method:'get',
               params:{'userName':sessionStorage.getItem('musicLogin')}
              }).then(function (resp) {
             
               if(resp.data){
                 
                   state.myMusic=resp.data
                    state.myMusicNum=resp.data.length
               }
                
          })
          .catch(function (err) {//测试网络异常(关闭后端服务器)
            
            _this.err = "发生错误，原因是:" + err.message;
                                                                   
          });
        }
    },
    actions: {
    },
    
}