<template>
<div id="slideshow">
  <el-carousel :interval="4000" type="card" height="295px">
    <el-carousel-item v-for="item in imgList" :key="item.id">
       <img :src="item.idView" class="image">
    </el-carousel-item>
  </el-carousel>
  </div>
</template>
<script>
export default {
    name:'SlideShow',
    data:function(){
        
        return{
            imgList:[
                {id:0,idView:require('../assets/p1.jpg')},
                {id:1,idView:require('../assets/p2.jpg')},
                {id:2,idView:require('../assets/p3.jpg')},
                {id:3,idView:require('../assets/p4.jpg')}           
            ]

        }
    }
}
</script>
<style>
  .el-carousel__item h3 {
    color: #475669;
    font-size: 14px;
    opacity: 0.75;
    line-height: 200px;
    margin: 0;
  }
  
  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
  }
  
  .el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
  }
.image{
     width: 100%;
     height: 100%;
  }
</style>
