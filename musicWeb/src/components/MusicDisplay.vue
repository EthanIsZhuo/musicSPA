<template>
    <div id="musicDispaly">
        <div id="dispalyNav">
            <img :src="require('../assets/sc1.jpg')" id="navImag"/>        
           <ul id="typeUl">
               <li id="typeLi"   v-for="(item,index) in typeList" :key="item.id" @click="getMusic(item.typeName),reds(index)" :class="{ red:changeRed == index}">{{item.typeName}} </li>
           </ul>

            <div id="navCut"></div>
            </div>
             <div id="allMusic">
              <music-table :musicList="musicList"></music-table>
            </div> 
       
    </div>
</template>
<script>
import { mapMutations } from 'vuex'
import MusicTable from './MusicTable.vue'
export default {
    name:'MusicDisplay',
    data:function(){
        return {
            changeRed:-1
        }
    },
    components:{
        MusicTable
        
    },
    computed:{
        typeList(){
       return this.$store.state.musicStore.typeList
     },
        musicList(){
         return this.$store.state.musicStore.musicList
     },
      myMusic(){
          return this.$store.state.myMusicStore.myMusic
      },
       
    },
    methods:{
        reds:function(index){
        
                    this.changeRed = index;
                },
        ...mapMutations(['getMusic']),
  
    }
    

}
</script>
<style>
#dispalyNav{
    width: 690px;
    text-align: left;
    height: 34.6px;
    padding:20px ;
    line-height:34.6px ;
}
#navImag{
       line-height:30px ;
       height:30px;
       float: left;
       margin-right: 40px;
}
#navName{
     line-height:34.6px ;
       height: 34.6px;
       font-weight: bold;
}
#navCut{
    position: relative;
    width:100%;
    bottom: -30px;
    border: 2px solid #c20c0c;
}

#typeUl li{
    float: left;
    margin-right:15px;
}
#allMusic{
    /* border: 1px solid red; */
    width: 690px;
   
    padding: 20px;
    padding-top:0px ;
    
}
#typeLi:hover{
    color: #c10d0c;
    font-weight: bold;
    
}
.red{
    color: #c10d0c;
      font-weight: bold;
}
.el-icon-video-play{
    color:#999;
  
}
.el-icon-video-play:hover{
    color:#333;
}

</style>