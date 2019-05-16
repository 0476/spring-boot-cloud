import Vue from 'vue';
import Vuex from 'vuex';
import VuexAlong from 'vuex-along';
Vue.use(Vuex);
const store = new Vuex.Store({
  state:{
    navIndex:10
  },
  plugins:[VuexAlong]
});
export default store;
