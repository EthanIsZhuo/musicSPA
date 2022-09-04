<template>
    <div id="musicBox">
            <div id="a">
            <audio  controls="controls" autoplay="autoplay" :src="musicUrl">
               
            </audio>
            </div>
    </div>
</template>
<script>
export default {
    data:function(){
         return{
          
         }
    },
    computed:{
        musicUrl(){ 
            return this.$store.state.musicStore.nowMusicUrl
        }
    }

}
</script>
<style>


audio{
    width: 100%;
}
</style>