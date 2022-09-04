<template>
  <div id="myMusic">
    <div id="left"></div>
    <div id="md">
      <div
        id="imag"
        v-bind:style="{
          backgroundImage: 'url(' + bg + ')',
          backgroundRepeat: 'no-repeat',
          backgroundSize: '100% 100%',
        }"
      ></div>
      <div id="mdHead">
        <h2 id="mdTitle">
          <div
            id="fa"
            v-bind:style="{
              backgroundImage: 'url(' + fa + ')',
              backgroundRepeat: 'no-repeat',
              backgroundSize: '100% 100%',
            }"
          ></div>
          我喜欢的音乐
        </h2>
        <div id="listTitle">
            歌曲列表<span id="mNum">共{{myMusicNum}}首</span>
            <span id="playNum">播放:<span id="pNum">{{playNum}}</span>次</span>
        </div>
      </div>
      <music-table :musicList="myMusic"></music-table>
    </div>
    
  </div>
</template>
<script>
import MusicTable from '../components/MusicTable.vue';
export default {
  components: { MusicTable },
  data: function () {
    return {
      bg: require("@/assets/cp.jpg"),
      fa: require("@/assets/gd.jpg"),
    };
  },
  computed: {
    myMusic() {
      return this.$store.state.myMusicStore.myMusic;
    },
    myMusicNum(){
          return this.$store.state.myMusicStore.myMusicNum;
    },
    playNum(){
        return this.$store.state.musicStore.playNum;
    }

  },
  methods: {
  
  },
  created(){
      this.$store.commit('getPlayNum')
  }
};
</script>
<style>
* {
  box-sizing: border-box;
}
#myMusic {
  position: relative;
  width: 980px;
  height: 1000px;
  margin-left: -490px;
  left: 50%;
  background-color: #fff;
}
#left {
  position: relative;
  width: 240px;
  height: 900px;
  background: #f9f9f9;
  border: 1px solid #ccc;
}
#md {
  position: absolute;
  top: 0px;
  right: 0px;
  width: 740px;
  height: 800px;
  border: 1px solid #ccc;
}
#imag {
  position: relative;
  margin: 45px;
  width: 208px;
  height: 208px;
}
#mdHead {
  position: absolute;
  top: 45px;
  width: 100%;
  height: 208px;
  /* border: 1px solid red; */
}
#fa {
  line-height: 30px;
  width: 54px;
  height: 24px;
  float: left;
}
#mdTitle {
  position: relative;
  left: 40%;
  width: 370px;
  text-align: left;
  height: 24px;

  line-height: 24px;
  font-weight: normal;
  margin: 0px;
  margin-top: 20px;
}
#emptyImg {
  position: absolute;
  top: 60px;
}
#listTitle{
    position: absolute;
    line-height: 34.6px;
    height: 34.6px;
    left: 10px;
    top:220px;
    z-index: 10;
    margin:0px;
    font-weight: normal;
    font-size: 20px;
    width:95%;
    padding-left: 20px;
    text-align: left;
    border-bottom:3px solid #c20c0c;
}
#mNum{
    padding: 20px;
    font-size: 14px;
    color:#666
}
#playNum{
    position:absolute;
    right: 0px;
    font-size: 14px;
}
#pNum{
  color: #c20c0c;
  font-weight: bold;

}
</style>