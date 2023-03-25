import { createRouter, createWebHistory } from 'vue-router';
import RegisterView from '../views/RegisterView';
import HomeView from '../views/HomeView';
import LoginView from '../views/LoginView';
import RegisterSuccess from '../views/RegisterSuccess'

import PersonalView from '../views/PersonalView'

const routes = [
  {
    path: '/HomeView',
    name: 'HomeView',
    component: HomeView,
    meta: {
      requestAuth: false,
    }
  },
  {
    path: '/RegisterView',
    name: 'RegisterView',
    component: RegisterView,
    meta: {
      requestAuth: false,
    }
  },
  {
    path: '/LoginView',
    name: 'LoginView',
    component: LoginView,
    meta: {
      requestAuth: false,
    }
  },
  {
    path: '/RegisterSuccess',
    name: 'RegisterSuccess',
    component: RegisterSuccess,
    meta: {
      requestAuth: false,
    }
  },
  {
    path: '/PersonalView',
    name: 'PersonalView',
    component: PersonalView,
    meta: {
      requestAuth: true,
    }
  },

]

const router = createRouter({
  history: createWebHistory(),
  routes
})

router.beforeEach((to, from, next) => {
  if (to.meta.requestAuth && !localStorage.getItem("jwt_token")) {
    next({ name: "LoginView" });
  }
  else {
    next();
  }
})

export default router
