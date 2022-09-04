import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)
import userStore from './userStore'
import uploadStore from './uploadStore'
import musicStore from './musicStore'
import myMusicStore from './myMusicStore'
export default new Vuex.Store({
  state: {
    
  },
  mutations: {
    
  },
  actions: {
  },
  modules: {
    userStore,
    uploadStore,
    musicStore,
    myMusicStore
  }
})
