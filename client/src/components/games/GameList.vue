<template>
  <div>
    <game-card
      v-for="game in games"
      :game=game
      :key="game.id" />
  </div>
</template>

<script>
import Service from '@/services/';
import GameCard from './gameCard';

export default {
  name: 'GameList',
  components: {
    GameCard,
  },
  data: () => ({
    games: [],
  }),
  async created() {
    this.games = await Service.gameService.get();
  },
};
</script>

<style>

</style>
