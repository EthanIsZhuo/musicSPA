<template>
    <div id="reg">

 <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm" >
       <el-form-item label="用户" prop="userName" >
    <el-input v-model="ruleForm.userName" placeholder="请输入注册用户名"></el-input>
  </el-form-item>
  <el-form-item label="密码" prop="pass">
    <el-input type="password" v-model="ruleForm.pass" autocomplete="off" placeholder="请输入密码"></el-input>
  </el-form-item>
  <el-form-item label="确认密码" prop="checkPass">
    <el-input type="password" v-model="ruleForm.checkPass" autocomplete="off" placeholder="请再次输入密码"></el-input>
  </el-form-item>
 
  <el-form-item>
    <el-button type="primary" @click="submitForm('ruleForm')">注册</el-button>
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
          return callback(new Error('年龄不能为空'));
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
      var validatePass2 = (rule, value, callback) => {
       
        if (value === '') {
          
          callback(new Error('请再次输入密码'));
        } else if (value !== this.ruleForm.pass) {
          callback(new Error('两次输入密码不一致!'));
        } else {
          callback();
        }
      };
    return {
      RLswitch: false,
      dialogVisible: this.$store.state.userStore.needLog,
     ruleForm: {
          pass: '',
          checkPass: '',
          userName: ''
        },
        rules: {
          pass: [
            { validator: validatePass, trigger: 'blur' }
          ],
          checkPass: [
            { validator: validatePass2, trigger: 'blur' }
          ],
          userName: [
            { validator: checkUserName, trigger: 'blur' }
          ]
        },
    

    };
  },


  methods: {
     //访问后台接口
      regInfo(){
        var _this=this
        this.$axios({
              url:'/regServlet',
              method:'post',
              params: { regName:this.ruleForm.userName,regPwd:this.ruleForm.pass}

            })
           .then(function (resp) {
              if(resp.data=="注册成功"){
                
                alert(resp.data)
                //通过全局方法改变选择，跳转到登录
                _this.$store.commit('changeSwitch','log')
              }else{
                alert(resp.data)
              }
              
        })
        .catch(function (err) {//测试网络异常(关闭后端服务器)
          
          this.err = "发生错误，原因是：" + err.message;
          
        });
      },
      submitForm(formName) {
        
        this.$refs[formName].validate((valid) => {
          if (valid) {
           
           
           this.regInfo()

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