<script setup>
import '@fortawesome/fontawesome-free/css/all.css';
import LoginCard from './components/Auth/LoginCard.vue';
import SignUpCard from './components/Auth/SignUpCard.vue';
import DisplayBackData from './components/DisplayBackData.vue';
import AddTask from './components/task/AddTask.vue';

import { ref } from 'vue';

const isSignInClicked = ref(false)
const isLoginClicked = ref(false)

const handleSignInOpen = () => {
  isSignInClicked.value = true
}

const handleSignInClose = () => {
  isSignInClicked.value = false
}

const handleLoginOpen = () => {
  isLoginClicked.value = true
}

const handleLoginClose = () => {
  isLoginClicked.value = false
}

</script>

<template>
  <header>
    <div>
      <h1>Gestionnaire de tâches</h1>
      <div class="authButton">
        <button @click="handleSignInOpen">Sign In</button>
        <button @click="handleLoginOpen">Login</button>
      </div>
    </div>
  </header>

  <main>
    <SignUpCard v-if="isSignInClicked" @closeFunction="handleSignInClose" />
    <LoginCard v-if="isLoginClicked" @closeFunction="handleLoginClose"/>
    <div class="containerApp">
      <DisplayBackData />
      <div class="separator"></div>
      <AddTask />
    </div>
  </main>
</template>

<style scoped>
header {
  background-color: #007bff;
  color: white;
  padding: 16px;
}
header > div {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.authButton button {
  margin-left: 20px;
  background-color: transparent;
  border: 2px solid #ffffff;
  color: #ffffff;
  padding: 8px 16px;
  border-radius: 20px;
  cursor: pointer;
  transition: background-color 0.3s, color 0.3s, border-color 0.3s;
}

.authButton button:hover {
  background-color: #ffffff;
  color: #007bff;
  border-color: #ffffff;
}

main {
  display: flex;
  margin: 1.5rem;
}

.separator {
  height: 2px;
  width: 100%;
  background-color: #4b4b4b;
  border-radius: 8px;
  margin: 20px 0px;
}

.containerApp {
  flex: 1;
  flex-direction: column;
}

</style>
