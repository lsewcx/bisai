<template>
  <nav-bar />
  <router-view />
</template>

<script>
  import NavBar from './components/NavBar';
  import 'bootstrap/dist/css/bootstrap.css';
  import 'bootstrap/dist/js/bootstrap.js';

  export default {
    name: 'App',
    components: {
      NavBar,
    }
  }
</script>