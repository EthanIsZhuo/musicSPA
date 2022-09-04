import axios from 'axios'
export default{
    state: {
       typeList:[],
       musicList:[],
        playNum:0,
       musicNum:0,
       key:"",
       nowMusicUrl:""
        
    },
    mutations: {
        //获得类型用于界面显示动态类型表(数据库更新类型时动态变化)
        getAllType:function(state){
          var _this=this
           axios({
               
            url:'/getTypeServlet',
            method:'get', 
           }).then(function (resp) {
            
            if(resp.data){
               
                state.typeList=resp.data
            }
             
       })
       .catch(function (err) {//测试网络异常(关闭后端服务器)
         
         _this.err = "发生错误，原因是:" + err.message;
                                                                
       });
         
        },

        //按照关键字获得对应音乐，服务于首页展示，分类展示，以及搜索功能。
        getMusic:function(state,searchKey){
          var _this=this
            axios({
                
             url:'/musicServlet',
             method:'get',
             params:{'searchKey':searchKey}
            }).then(function (resp) {
             
             if(resp.data){
                
                 state.musicList=resp.data
                state.musicNum=resp.data.length
                state.key=searchKey
             }
              
        })
        .catch(function (err) {//测试网络异常(关闭后端服务器)
          
          _this.err = "发生错误，原因是:" + err.message;
                                                                 
        });
          
         },
         //播放音乐 对已登录用户记录播放次数
         playMusic:function(state,name){
          state.nowMusicUrl="http://localhost:8090/musicApi/Music/"+name
          var _this=this
        
           axios({
                
            url:'/addPlayCount',
            method:'get',
            params:{'userName':sessionStorage.getItem('musicLogin')}
           }).then(function (resp) {
          
            if(resp.data){
              state.playNum=resp.data
            }
             
       })
       .catch(function (err) {//测试网络异常(关闭后端服务器)
         
         _this.err = "发生错误，原因是:" + err.message;
                                                                
       });
         },
         getPlayNum:function(state){
          var _this=this
        
          axios({
               
           url:'/getPlayNum',
           method:'get',
           params:{'userName':sessionStorage.getItem('musicLogin')}
          }).then(function (resp) {
         
           if(resp.data){
            
             state.playNum=resp.data
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