import Vue from 'vue';
import Router from 'vue-router';
import { Games, Users } from '@/views';

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: '/games',
      name: 'Games',
      component: Games,
    },
    {
      path: '/users',
      name: 'Users',
      component: Users,
    },
  ],
});
