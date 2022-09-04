<template>
  <div id="appHeader">
   
    <ul id="nav">
        <li><img :src="require('../assets/logo.png')"></li>
        <li id="navWord" @click="changeView('/')">发现音乐</li>
        <li  id="navWord"  @click="changeView('/myMusic')">我的音乐 </li>
         <li  id="navLi">
        <div id="nInput">
        <el-input  placeholder="请输入内容" v-model="searchKey" clearable @change="toSearch(searchKey)"></el-input>
       
        </div>

        </li>
        <li v-if="!isLog">
         
          <a id="aLogin" @click="toLogin" >登录 </a>
          
          </li>
           <li v-else>
             欢迎您!{{loginName}}  <a id="out" @click="outLogin">退出</a>      
          </li>
        <li><el-button :style="myButton" type="primary" @click="toUpload">歌曲上传<i class="el-icon-upload el-icon--right"></i></el-button></li>
    </ul>
    <!-- 登录注册组件 -->
      <Rl-form  v-if="loginV"></Rl-form>
      <!-- 歌曲上传组件 -->
       <Up-load-form v-if="uploadV"></Up-load-form>
      
  </div>
</template>
<script>
import RlForm from '@/components/RlForm.vue'
import { mapMutations} from 'vuex'
import UpLoadForm from './UpLoadForm.vue';

export default {
    data:function(){
  
    return {
      searchKey: '',
       
      
      myButton:{
          backgroundColor: "#e60026",
          border:"none"
      }

    }
  },
  components:{
    UpLoadForm,
    RlForm
    
   
  },
  methods:{
     ...mapMutations(['toLogin','toUpload']),
     outLogin(){
       this.$router.push('/')
       this.$store.commit('outLogin')
     },
     changeView:function(v){
       if(v=='/'){
         this.$store.commit('getMusic')
       }
       this.$router.push(v)
       
       
     },
     toSearch(key){
        this.$router.push('/search')
        this.$store.commit('getMusic',key)
     }
  },
  computed:{
    isLog(){ return this.$store.state.userStore.isLog},
   loginName(){return this.$store.state.userStore.loginName},
    loginV(){
      
      return this.$store.state.userStore.needLog
    },
    uploadV(){
       return this.$store.state.uploadStore.needUpload
    }

  },
  created(){
    this.$store.commit('getLoginName')
  }
  
};
</script>

<style>
ul{
   
    list-style: none;
    margin:0px;
}
#appHeader {
  width: 100%;
  height: 70px;
  background: #242424;
}
#nav{
    position: relative;
    width: 1300px;
    left: 50%;
    margin-left: -650px;
}
#nav li{
    float: left;
    color:#fff;
    padding:0 19px;
    height:70px;
     line-height: 70px;
    
}
#navWord:hover{
    background: black;
}
#navInput{
    width: 200px;
}
#nInput{
    width: 250px;
   /* border: 1px solid red; */
    line-height: 70px;
    height: 70px;
   float:left
}
#btnSearch{
    margin-left: 5px;
    float:left
}
#aLogin{
    color:#787878;
    text-decoration: none;
}
#out{
  text-decoration: underline;
  color:#787878;
}
</style>
