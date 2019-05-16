<template>
  <div id="app">
    <div class="top">
      <div class="main"><span class="left">客服热线  <strong>010 - 60 211 211</strong></span><span class="right"><a href="登录.html">登录</a>|<a href="注册前.html">免费注册</a>|<a href="个人中心1_1.html">个人管理中心</a>|<a href="">软件下载</a></span></div>
    </div>
    <div class="head">
      <div class="main">
        <a href="" class="left"><img src="./assets/images/logo.png"></a>
        <a href="空中课堂_1.html" class="headkong"><span>空中课堂</span></a>
        <div class="nav">
          <ul>
            <!-- 导航列表 -->
            <li :class=" navItem.navIndex === index ? 'item-cn cur' : 'item-cn'" v-for="(item, index) in nav" @click="routerLink(index, item.path)" :key="index">
              <a>{{ item.title }}</a>
            </li>
<!--            <li class="cur"><router-link :to="{ name: 'Home' }" >首页</router-link></li>-->
<!--            <li><router-link :to="{ name: 'Teacher' }" >师资</router-link></li>-->
<!--            <li><router-link :to="{ name: 'Student' }" >同学</router-link></li>-->
<!--            <li><router-link :to="{ name: 'Advantage' }" >优势</router-link></li>-->
<!--            <li><router-link :to="{ name: 'Guide' }" >使用指南</router-link></li>-->
          </ul>
        </div>

        <div class="clear"></div>
      </div>
    </div>
    <router-view/>
    <div class="footer"><br>
      <div class="main">
        <a href="#" class="backtop"></a>
        <dl>
          <dt>帮助中心</dt>
          <dd><a href="">服务条款</a><a href="">网站资源</a></dd>
        </dl>
        <dl>
          <dt>服务支持</dt>
          <dd><a href="">意见反馈</a></dd>
        </dl>
        <dl>
          <dt>关注我们</dt>
          <dd><a href="">联系我们</a></dd>
        </dl>
        <dl>
          <dt>关于佳教通</dt>
          <dd><a href="">官方教学顾问</a></dd>
        </dl>
        <span class="right">经营许可证编号： 京ICP备10022571号-3    <br>© 2007-2016 佳教通 版权所有</span>
        <div class="clear"></div>
      </div>
      <br><br>
    </div>
  </div>
</template>
<style >
  @import "assets/css/public.css";
  body{
    display: block;
    margin: 0px!important;
  }
</style>
<script>
import router from '@/router';
  var app = {
    name: 'App',
    data() {
      return {
        nav: [
          {
            path: '/',
            title:'首页',
            name: 'Home'
          },{
            path: '/teacher',
            title:'教师',
            name: 'Teacher'
          },{
            path: '/student',
            title:'同学',
            name: 'Student'
          },{
            path: '/advantage',
            title:'优势',
            name: 'Advantage'
          },{
            path: '/guide',
            title:'使用指南',
            name: 'Guide'
          }
        ],
        navItem:{
          navIndex: 0,
        }
      }
    },
    watch: {
      $route(to) {
        // 获取当前路径
        let path = this.$route.path;
        // 检索当前路径
        this.checkRouterLocal(path);
      }
    },
    methods:{
      setNavIndex: function (index) {
        console.log("this index "+index);
        // console.log(this.$set);
       // this.navItem.navIndex=index;
      },

      /**
       * 路由跳转
       * @param index
       * @param link
       */
      routerLink(index, path) {
        console.log(this.$store);
        // 点击哪个路由就赋值给自定义的下下标
        this.navItem.navIndex = index;
        // 路由跳转
        this.$router.push(path)
      },
      /**
       * 检索当前路径
       * @param path
       */
      checkRouterLocal(path) {
        // 查找当前路由下标高亮
        this.navItem.navIndex = this.nav.findIndex(item => item.path === path);
      }
    }
  }
  export default app;
  router.beforeEach((to, from, next) => {
    // 获取当前路径
    let path = to.path;
    console.log(path);
    console.log(app.data().navItem.navIndex);
    var index = app.data().nav.findIndex(item => item.path === path);
    console.log(app.data().nav);
    console.log(index);
    app.methods.setNavIndex(index);
    console.log(app.data().navItem.navIndex);
    // 检索当前路径
    //app.methods.checkRouterLocal(path);
    next();

  });
</script>
