<template>
  <div class="header">
    <div class="header-logo">
      <h1>Inside <a href="#/games">Game</a></h1>
    </div>
    <div class="header-buttons">
      <span>Home</span>
      <a href="#/users">Layout</a>
      <span v-if="user === 'admin'">Tools</span>
      <button @click="loginModal()">Sign In</button>
      <button>Sign up</button>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Navbar',
  data: () => ({
    user: 'lyes',
  }),
};
</script>

<style lang='scss' scoped>
.header {
  display: flex;
  flex-direction: row;
  background-color: #333;
  justify-content: space-between;
  padding: 10px;
  font-family: Source Sans Pro;
  .header-logo{
    h1{
      color: white;
      font-size: 20px;
    }
    a{
      text-decoration: none;
      color: #AAA;
    }
    padding: 5px;
  }
  .header-buttons{
    font-size: 20px;
    margin-top: 5px;
    a{
      color: white;
    }
    button{
      border-radius: 7px;
      border:solid 2px white;
      color: white;
      background-color: transparent;
      padding: 5px 15px;
      margin: 5px;
    }
    span{
    color: white;
    margin: 5px;
    }
  }
}
</style>
