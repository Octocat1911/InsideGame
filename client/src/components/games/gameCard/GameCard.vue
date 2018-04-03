<template>
  <div class="card">
        <div class="card-content">
          <p class="title">
            {{game.name}}
          </p>
        </div>
        <footer class="card-footer">
          <p class="card-footer-item">
            <span>
              id : <a>{{game.id}}</a>
            </span>
          </p>
          <p class="card-footer-item">
            <span>
              Users : <a>{{game.userCount}}</a>
            </span>
          </p>
        </footer>
      </div>
</template>

<script>
export default {
  name: 'GameCard',
  props: {
    game: {
      type: Object,
      require: true,
    },
  },
};
</script>

<style lang='scss' scoped>
  .card{
    margin: 10px;
  }
</style>
