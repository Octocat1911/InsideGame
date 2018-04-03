<template>
  <game-list class="game-list"/>
</template>

<script>
import GameList from '@/components/games';

export default {
  name: 'Games',
  components: {
    GameList,
  },
};
</script>

<style lang='scss' scoped>
  .game-list{
    display: flex;
    flex-direction: row;
  }
</style>
