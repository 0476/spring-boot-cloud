<template>
  <div class="hello">
    <!--banner-->
    <div class="banner">
      <div class="main"><p><span class="f48">数万名优秀师资  私人定制教学方案</span><br><span class="f24">6万多名师资源，轻松找到你心仪的老师</span></p></div>
    </div>

    <!--面包屑
    <div class="main bread">
    当前位置：<a href="首页.html">首页</a>&gt;<a href="师资.html">师资</a>
    </div>
    -->
    <!--search-->
    <div class="main">
      <div class="seartab">
        <div class="searcont">
          <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td width="300"><p>教学科目：<select name="" size="1">
                <option>请选择</option>
              </select><select name="" size="1">
                <option>请选择</option>
              </select></p></td>
              <td><p>用户名：<input name="" type="text" class="stxt"><input name="" type="button" value="搜索" class="sbtn"></p></td>
            </tr>
          </table>

        </div>
      </div>
    </div>
    <div class="main">
      <div class="plist">
        <ul>

          <li>
            <div class="litpic"><img src="../assets/images/pic09.jpg"></div>
            <div class="ptxt">
              <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td width="320"><p>用户名： chenjun</p>
                    <p>小学生</p><p>科目：小学英语，小学语文，小学作文，小
                      学英语，初中英语</p></td>
                  <td width="230"><p>级别：15级<img src="../assets/images/t.jpg"></p>
                    <p>评分：9.95</p><p>网络：移动</p></td>
                  <td width="230"><p>状态：<span class="stah">在线</span></p><p>老师要求：</p><p>性别：女</p></td>
                  <td><p><img src="../assets/images/rz_web.jpg">网站认证</p><p><img src="../assets/images/rz_true.jpg">实名认证</p></td>
                </tr>
              </table>
            </div>
            <div class="clear"></div>
          </li>
          <li>
            <div class="litpic"><img src="../assets/images/pic09.jpg"></div>
            <div class="ptxt">
              <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td width="320"><p>用户名： chenjun</p>
                    <p>小学生</p><p>科目：小学英语，小学语文，小学作文，小
                      学英语，初中英语</p></td>
                  <td width="230"><p>级别：15级<img src="../assets/images/t.jpg"></p><p>评分：9.95</p><p>网络：移动</p></td>
                  <td width="230"><p>状态：<span class="sta">离线</span></p><p>老师要求：</p><p>性别：女</p></td>
                  <td><p><img src="../assets/images/rz_web.jpg">网站认证</p><p><img src="../assets/images/rz_true.jpg">实名认证</p></td>
                </tr>
              </table>
            </div>
            <div class="clear"></div>
          </li>

        </ul>
      </div>
      <div class="pages">
        <ul>
          <li><a href="首页.html">首页</a></li><li class="cur"><a href="">1</a></li><li><a href="">2</a></li><li><a href="">3</a></li><li><a href="">末页</a></li>
        </ul>
      </div>
    </div>
    <br>
  </div>
</template>

<script>
export default {
  name: 'Student',
  data () {
    return {
      msg: 'Welcome to Vue Student'
    }
  }

}
</script>

