<template>
    <div id="musictable">
<el-table
                :data="musicList"
                stripe
                height="600"
                style="width: 100%"
               
             @row-dblclick="select"
                >
                 <el-table-column
               type="index"
                label="歌曲"
                width="80px"                  
                >         
                </el-table-column>
               <el-table-column
              
                label="歌曲名称"
                width="180">
                <template slot-scope="scope">
                <i class=" el-icon-video-play" @click="paly(scope.row.musicUrl)"></i>
                 <span style="margin-left: 10px">{{ scope.row.musicName }}</span>
                </template>
                </el-table-column>
                <el-table-column
                prop="singer"
                label="歌唱者"
                width="100">
                </el-table-column>
                <el-table-column
               
                label="上传时间">
                 <template slot-scope="scope">
                <i class="el-icon-time"></i>
                 <span style="margin-left: 10px">{{ scope.row.uploadTime }}</span>
                </template>
            </el-table-column>
             <el-table-column
                 width="60"
                label="操作">
                 <template slot-scope="scope">
               <i class="fa fa-heart-o" v-if="!isLove(scope.row.musicId)" aria-hidden="true" @click="changeLove(scope.row.musicId)"></i>
              <i class="fa fa-heart" v-if="isLove(scope.row.musicId)" aria-hidden="true" @click="changeLove(scope.row.musicId)"></i>
                </template>
            </el-table-column>
             <div slot="empty">
                     <p>
						<img :src="require('@/assets/wu.jpg')"/>
					</p>
                 
        </div>
            </el-table>
            
    </div>
</template>
<script>
export default {
    name:'MusicTable',
    props:['musicList'],
    data:function(){
        return{

        }
    },
    methods:{
         paly:function(name){
             
             this.$store.commit('playMusic',name)
        },
       select:function(row){
          this.$store.commit('playMusic',row.musicUrl)
       },
        changeLove(id){
            if(sessionStorage.musicLogin!=null){
            this.$store.commit('changeLoveState',id)
            
         
            }else{

                alert("请先登录")
                this.$store.commit('toLogin')
            }
        },

        //用这个函数判断是否已被收藏
      isLove(id){
           var flag= this.$store.state.myMusicStore.myMusic.find(ele=>
           
                ele.musicId==id
            )
           
            if(flag){
                return true
            }
      }
    }
}
</script>
<style>
.fa{
    color: #c20c0c;

}
</style>