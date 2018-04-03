<template>
  <Layout>
    <router-view slot="content"/>
  </Layout>
</template>

<script>
import Layout from '@/components/layout';

export default {
  name: 'App',
  components: {
    Layout,
  },
};
</script>

<style lang="scss">
  @import '../node_modules/normalize.css/normalize.css';
</style>
