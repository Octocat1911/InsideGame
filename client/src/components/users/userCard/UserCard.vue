<template>
  <div class="card">
        <div class="card-content">
          <p class="title">
            {{user.firstname}}
          </p>
          <p class="subtitle">
            {{user.lastname}}
          </p>
        </div>
        <footer class="card-footer">
          <p class="card-footer-item">
            <span>
              mail : <a>{{user.email}}</a>
            </span>
          </p>
        </footer>
      </div>
</template>

<script>
export default {
  name: 'UserCard',
  props: {
    user: {
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
