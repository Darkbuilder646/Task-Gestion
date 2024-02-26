<script setup>
const emit = defineEmits(['closeFunction']) //* Event

const handleClose = () => {
  emit('closeFunction')
}
defineExpose({ handleClose: () => emit('closeFunction') })
</script>

<script>
import AuthService from "../../service/AuthService"

export default {
  data() {
    return {
      form: {
        email:'',
        password:''
      }
    }
  },
  methods: {
    onSubmit() {
      console.log("Result from form : " + JSON.stringify(this.form));
      this.handleLogin(this.form.email, this.form.password);
    },
    handleLogin(email, password) {
      AuthService.login(email, password)
      .then((res) => {
        if(res.status === 200) {
          console.log("Login success");

          this.handleClose();
        }
      })
      .catch((error) => {
        console.log("Error : " + error);
      })
    },
    handleClose() {
      this.$emit('closeFunction');
    }
  }
}
</script>

<template>
    <div class="popUpParent">
    <div class="blurBackground"></div> 
    <div class="card">
      <button class="closeButton" @click="handleClose">X</button>
      <form class="formLogin" @submit.prevent="onSubmit">

        <label for="email">Your Email</label>
        <input type="email" name="email" id="email" required v-model="form.email">

        <label for="password">Your Password</label>
        <input type="password" name="password" id="password" required v-model="form.password">

        <button type="submit" class="loginButton" name="Login">Login</button>
      </form>
    </div>
  </div>
</template>

<style scoped>
.popUpParent {
  position: fixed;
  display: flex;
  align-items: center;
  justify-content: center;
  inset: 0;
  height: 100vh;
  z-index: 20;
}

.blurBackground {
  position: fixed;
  inset: 0;
  background-color: rgba(240, 240, 240, 0.25); 
  backdrop-filter: blur(5px); 
}


.card {
  position: relative;
  background-color: white;
  width: 50%;
  max-width: 600px;
  padding: 2rem;
  z-index: 30;
  border-radius: 8px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
}

.closeButton {
  position: absolute;
  right: 10px;
  top: 10px;
  background-color: red;
  border: 1px solid black;
  border-radius: 50%;
  width: 25px;
  height: 25px;
  color: white;
  font-weight: bold;
  cursor: pointer;
}

.closeButton:hover {
  background-color: #dd0000;
}

.formLogin {
  display: flex;
  flex-direction: column;
}

.formLogin label {
  margin-top: 12px;
}

.formLogin input {
  padding: 4px;
}

.loginButton {
  align-self: center;
  margin-top: 12px;
  padding: 8px 16px;
  width: 150px;
  background-color: #007bff;
  border: 2px solid #ffffff;
  border-radius: 20px;
  color: #ffffff;
  font-weight: bold;
  cursor: pointer;
  transition: border-color 0.3s;
}

.loginButton:hover {
  border-color: #0057b4;
}

</style>