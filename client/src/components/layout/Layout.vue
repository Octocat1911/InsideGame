<template>
  <div>
    <Navbar></Navbar>
    <slot name="content">
      <Home></Home>
    </slot>
  </div>
</template>

<script>
import Home from '@/views/Home';
import Navbar from './navbar';

export default {
  name: 'Layout',
  components: {
    Navbar,
    Home,
  },
};
</script>


<style lang="scss" scoped>

</style>
