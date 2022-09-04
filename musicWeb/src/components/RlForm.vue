<template>
  <div class="rlform">
    <el-dialog :visible.sync="dialogVisible" width="450px" @close="handleClose">
      <el-button :style="switchBt" @click="changeSwitch('log')">登录</el-button>
      <el-button :style="switchBt" @click="changeSwitch('reg')">注册</el-button>
   
    <reg-form v-if="RLswitch"></reg-form>
    <login-form  v-if="!RLswitch"></login-form>

    </el-dialog>
  </div>
</template>
<script>
import { mapMutations } from 'vuex';
import LoginForm from './LoginForm.vue'
import RegForm from './RegForm.vue'
export default {
  name: "RlForm",
  data:function() {   
    return {
      // RLswitch: false,
      // dialogVisible: this.$store.state.userStore.needLog,
    
     //样式
     dialogVisible:  this.$store.state.userStore.needLog,
      switchBt: {
        width: "200px",
        border: "none",
        fontSize: "20px",
        fontWeight: "bold",
      },
      
    };
  },
components:{
  RegForm,
  LoginForm
},
computed:{
  RLswitch(){
    return this.$store.state.userStore.switchRL
  },
 
},
  methods: {
  
    //关闭弹窗的时候将全局的needLog改为flase
    handleClose() {
      this.$store.state.userStore.needLog = false;
      this.dialogVisible = false;
    },
  
     
    //按钮改变登录和注册表单
...mapMutations(['changeSwitch'])
  },
};
</script>
