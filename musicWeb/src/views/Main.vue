<template>
  <div class="main">
  
    <slide-show></slide-show>
  <div id="display">
    <music-display></music-display>
  </div>
  </div>
</template>

<script>  


import SlideShow from '@/components/SlideShow.vue' 

import MusicDisplay from '@/components/MusicDisplay.vue' 

export default {
  name: 'Main',
  data:function(){
    return{
      
    }
    
  },
  components:{
    SlideShow,
    MusicDisplay
 
    }
}
</script>
<style>
 body{
   background: #f5f5f5;
 }
 #display{
   position: relative;
   margin-left:-500px ;
   left: 50%;
   min-height: 800px;
   width: 1000px;
   height: auto;
   /* border:1px solid red; */
   background: #fff;
 }
</style>