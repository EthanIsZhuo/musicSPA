<template>
  <div id="uploadform">
    <el-dialog :visible.sync="uploadVisible" width="480px" @close="handleClose">
      <el-form
        ref="musicForm"
        :model="musicForm"
        :rules="rules"
        label-width="120px"
      >
        <el-form-item label="歌曲名称" prop="musicName">
          <el-input
            v-model="musicForm.musicName"
            placeholder="请输入歌手名称"
            :style="myInput"
          ></el-input>
        </el-form-item>
        <el-form-item label="歌手" prop="singer">
          <el-input
            v-model="musicForm.singer"
            placeholder="请输入歌手"
            :style="myInput"
          ></el-input>
        </el-form-item>
        <el-form-item label="音乐类型">
          <el-select
            v-model="musicForm.type"
            placeholder="请选择音乐类型"
            :style="myInput"
          >
            <el-option
              v-for="item in typeList"
              :key="item.id"
              :label="item.typeName"
              :value="item.typeName"
            >
      
            </el-option>
          </el-select>
        </el-form-item>
        <el-upload
          class="upload-demo"
          drag
          action=""
          multiple
          ref="upload"
          :on-change="change"
          :auto-upload="false"
          :limit="1"
          :http-request="upload"
        >
          <i class="el-icon-upload"></i>
          <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
          <div class="el-upload__tip" slot="tip">
            只能上传mp3文件，且不超过1024MB
          </div>
        </el-upload>
      </el-form>

      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitUpload">上传歌曲</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>


export default {
  name: "UploadForm",
  data: function () {
    var checkName = (rule, value, callback) => {
      if (!value) {
        return callback(new Error("该歌曲信息不能为空"));
      } else {
        callback();
      }
    };
    return {
        
      uploadVisible: this.$store.state.uploadStore.needUpload,
      musicForm: {
        musicName: "",
        type: "",
        singer: "",
      },
      myInput: {
        width: "320px",
      },
      rules: {
        musicName: [{ validator: checkName, trigger: "blur" }],
        singer: [{ validator: checkName, trigger: "blur" }],
      },
    };
  },
  computed: {
    
   typeList(){
       return this.$store.state.musicStore.typeList
   }
  },
 

  methods: {
    handleClose() {
      this.$store.state.uploadStore.needUpload = false;
    },
    change(filetemp) {
      //上传文件的时候进行判断:此处将文件信息作分割自动
   
      var Name = filetemp.name;
      var idx = Name.lastIndexOf(".");
      
      if (idx != -1) {
        var ext = Name.substr(idx + 1); // alert(ext)
        if (ext != "mp3") {
          alert("仅允许传入mp3文件");
          this.$refs.upload.clearFiles();
          return;
        }
     
     
      } else {
        alert("文件有误");
      }
      var t = Name.indexOf("-");
      this.musicForm.musicName=Name.substr(t+1, idx-t-1)
      this.musicForm.singer = Name.substr(0, t);
    },
    submitUpload() {
      this.$refs.upload.submit();
    },
    upload(filetemp) {
     
      if (this.musicForm.type == "") {
        alert("请选择类型");
      } else {
        if (filetemp.file.size == 0) {//文件大小为0是时代表未填充文件上传区域
          
          alert("请上传文件");
          return;
        }
        let parms = new FormData();
        parms.append("file", filetemp.file); 
        parms.append("musicName", this.musicForm.musicName);
        parms.append("singer", this.musicForm.singer);
        parms.append("type", this.musicForm.type);
        parms.append("userName", this.$store.state.userStore.loginName); //上传者
        var _this = this;
        this.$axios
          .post("/uploadMusic", parms, {
            headers: { "Content-Type": "multipart/form-data" },
          })
          .then(function (resp) {
            alert(resp.data);
            location.reload();
            console.log(resp.data)
            _this.uploadVisible = false;
          })
          .catch(function (err) {
            alert(err.message);
          });
      }
    },
  },
};
</script>
<style scoped>
.dialog-footer {
  text-align: center;
}
.el-button--primary {
  background: #e60026;
  border: none;
}
.el-button--primary:focus,
.el-button--primary:hover {
  background: #c20c0c;
}
</style>