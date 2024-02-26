<script setup>
const emit = defineEmits(['closeFunction']) //* Event

const handleClose = () => {
  emit('closeFunction')
};
defineExpose({ handleClose: () => emit('closeFunction') })
</script>

<script>
import AuthService from "../../service/AuthService"

export default {
  data() {
    return {
      form: {
        username:'',
        email:'',
        password:''
      }
    }
  },
  methods: {
    onSubmit() {
      console.log("Result from form : " + JSON.stringify(this.form));
      this.handleSignUp(this.form.username, this.form.email, this.form.password);
    },
    handleSignUp(username, email, password) {
    AuthService.register(username, email, password)
    .then((res) => {
      if(res.status === 200) {
        console.log("Register Success");

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
};

</script>

<template>
  <div class="popUpParent">
    <div class="blurBackground"></div> 
    <div class="card">
      <button class="closeButton" @click="handleClose">X</button>
      <form class="formSignUp" @submit.prevent="onSubmit">
        <label for="name">Your name</label>
        <input type="text" name="name" id="name" required v-model="form.username">

        <label for="email">Your email</label>
        <input type="email" name="email" id="email" required v-model="form.email">

        <label for="password">Your password</label>
        <input type="password" name="password" id="password" required v-model="form.password">
        <button type="submit" class="signUpButton" name="signUp">Sign Up</button>
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

.formSignUp {
  display: flex;
  flex-direction: column;
}

.formSignUp label {
  margin-top: 12px;
}

.formSignUp input {
  padding: 4px;
}

.signUpButton {
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

.signUpButton:hover {
  border-color: #0057b4;
}

</style>
