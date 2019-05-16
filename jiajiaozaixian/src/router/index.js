import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
import Teacher from '@/components/Teacher'
import Student from '@/components/Student'
import Advantage from '@/components/Advantage'
import Guide from '@/components/Guide'

Vue.use(Router)

var router = new Router({
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/teacher',
      name: 'Teacher',
      component: Teacher
    },
    {
      path: '/student',
      name: 'Student',
      component: Student
    },
    {
      path: '/advantage',
      name: 'Advantage',
      component: Advantage
    },
    {
      path: '/guide',
      name: 'Guide',
      component: Guide
    }
  ]
});
export default router;


// var getLastUrl=(str,yourStr)=>str.slice(str.lastIndexOf(yourStr))//取到浏览器出现网址的最后"/"出现的后边的字符
