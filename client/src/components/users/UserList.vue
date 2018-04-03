<template>
  <div>
    <user-card
      v-for="user in users"
      :user=user
      :key="user.id" />
  </div>
</template>

<script>
import Service from '@/services';
import UserCard from './userCard';

export default {
  name: 'UserList',
  components: {
    UserCard,
  },
  data: () => ({
    users: [],
  }),
  async created() {
    this.users = await Service.userService.get();
  },
};
</script>

<style>

</style>
