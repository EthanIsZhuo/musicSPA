<template>
    <div id="search">
        <input type="text" id="searchInput" v-model="input" placeholder="请输入搜索内容" @change="toSearch(input)">
        <el-button type="primary" icon="el-icon-search" :style="searchBtn" @click="toSearch(input)">搜索</el-button><br>
        <span id="tip">搜索"<i id="tipInfo">{{key}}</i>"，找到<i id="tipInfo">{{num}}</i>首单曲</span>
        <div id="searchDisplay">
     
            <music-table :musicList="musicList"></music-table>
        </div>
    </div>
</template>
<script>
import MusicTable from '../components/MusicTable.vue'
export default {
  components: { MusicTable },
    name:'Search',
    data:function(){
        return{
            input:'',
            searchBtn:{
                color:"#333",
                backgroundColor:"#f5f5f5",
                border:"none"
            },
            

        }
    },
    computed:{
         musicList(){
         return this.$store.state.musicStore.musicList
     },
     num(){
         return this.$store.state.musicStore.musicNum
     },
     key(){
         return this.$store.state.musicStore.key
     }
    },
    methods:{
        toSearch(k){
            this.$store.commit('getMusic',k)
        },
  
    }
}
</script>
<style  >
#search{
    position: relative;
    width: 1000px;
    height: 1000px;
    margin-left:-500px ;
    padding-top:50px ;
    left: 50%;
    background-color: #fff;
}
#searchInput{
    height: 32px;
    width: 200px;
    outline: none;
    border-radius: 3px;
    border: 1px solid #ccc;
}
#searchDisplay{
    position: relative;
    top:32px;
    width: 800px;
    height: 800px;
    margin-left:-400px ;
    left: 50%;

}
#tip{
    position: absolute;
    left: 100px;
    
    width: 800px;
    text-align: left;
    color: #999;
    font-size: 13px;
    /* border:1px solid red; */
}
#tipInfo{
    color:#c20c0c
}
#without{
    position: absolute;
    top:160px
}
</style>