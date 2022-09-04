<template>
    <div id="login">
        <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm" >
       <el-form-item label="用户" prop="userName" >
    <el-input v-model="ruleForm.userName" placeholder="请输入用户名"></el-input>
  </el-form-item>
  <el-form-item label="密码" prop="pass">
    <el-input type="password" v-model="ruleForm.pass" autocomplete="off" placeholder="请输入密码"></el-input>
  </el-form-item>
  
 
  <el-form-item>
    <el-button type="primary" @click="submitForm('ruleForm')">登录</el-button>
    <el-button @click="resetForm('ruleForm')">重置</el-button>
  </el-form-item>
        </el-form>
    </div>
</template>
<script>

export default {
  name: "RlForm",
  data() {
    //  element ui提供的对于表单规则的判断
   var checkUserName = (rule, value, callback) => {
        if (!value) {
          return callback(new Error('用户名不能为空'));
        }else{
          callback();
        }
        
      
      };
      var validatePass = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入密码'));
        } else {
          if (this.ruleForm.checkPass !== '') {
            this.$refs.ruleForm.validateField('checkPass');
          }
          callback();
        }
      };
     
    return {
      RLswitch: false,
      // dialogVisible: this.$store.state.userStore.needLog,
     ruleForm: {
          pass: '',
          userName: ''
        },
        rules: {
          pass: [
            { validator: validatePass, trigger: 'blur' }
          ],
          
          userName: [
            { validator: checkUserName, trigger: 'blur' }
          ]
        },
    

    };
  },


  methods: {
    LoginAccount(){
      var _this=this
      this.$axios({
              url:'/loginServlet',
              method:'post',
              params: { userName:this.ruleForm.userName,userPwd:this.ruleForm.pass}

            })
           .then(function (resp) {
             if(resp.data!=='Yes')
             {
              alert(resp.data)
             }else{
               alert("登录成功");
               sessionStorage.setItem('musicLogin',_this.ruleForm.userName);
               _this.$store.commit('changeLoginState',true)
               _this.$store.state.userStore.needLog=false
               location.reload()
             }
              
        })
        .catch(function (err) {//测试网络异常(关闭后端服务器)
          
          this.err = "发生错误，原因是：" + err.message;
          
        });

    },
  
  
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
           
            this.LoginAccount()
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
   
  },
};
</script>