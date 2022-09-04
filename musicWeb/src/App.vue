<template>
  <div id="app">
    <app-header></app-header>
    <div id="cutLine"></div>

    <router-view/>
    <music-box></music-box>
 
  </div>
</template>
<script>
import AppHeader from '@/components/AppHeader.vue'
import MusicBox from '@/components/MusicBox.vue'


export default {
  name:'app',
   components: {
    
    AppHeader,
    MusicBox,
   
     
  },
  computed:{
       show(){
         alert(this.$store.state.userStore.needLog)
          return this.$store.state.userStore.needLog
        }
  },
   created(){
    
      this.$store.commit("getAllType")
      this.$store.commit("getMusic")
      this.$store.commit("getMyMusic")
  },
}
</script>
<style>
body{
  margin: 0px;
  padding: 0px;
}
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
#cutLine{
  width:100%;
  height: 5px;
  background-color: #c20c0c;
}
#musicBox{
  position: fixed;
  bottom: -45px;
  width:100%;
  z-index: 20;
  height: 50px;
  background-color: #242424;
  background-repeat: repeat-x;
  transition: 1s;
  transition-delay: 3s;
}
#musicBox:hover{
   bottom: 0px;
   transition:0.01s;
}
</style>
