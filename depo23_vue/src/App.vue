<template>
  <div id="app">
    <Bonds />
    <BondItem />
  </div>
</template>

<script>
import Bonds from './components/Bonds.vue'
import BondItem from './components/BondItem.vue'

export default {
  name: 'App',
  components: {
    Bonds,
    BondItem
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>