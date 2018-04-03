<template>
  <div class="home">
      <h1>Hello {{user}} welcome to Inside Game</h1>
  </div>
</template>

<script>
export default {
  name: 'Home',
  data: () => ({
    user: 'lyes',
  }),
};
</script>

<style lang='scss'>
.home{
  display: flex;
  justify-content: center;
  flex-direction: column;
  align-items: center;
  font-family: Source Sans Pro;
  font: "Source Sans Pro", sans-serif;
}
</style>
