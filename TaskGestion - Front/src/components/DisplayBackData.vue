<script>
import axios from "axios";

export default {
  data() {
    return {
      message: "nothing here",
      data: "",
    };
  },
  methods: {
    handleButton: function () {
      axios
        .get("http://localhost:8080/api/tasks/getTasks")
        .then((response) => {
          this.message = JSON.stringify(response.data);
        })
        .catch((error) => {
          console.error("Erreur lors de la récupération des données:", error);
        });
    },
  },
};
</script>

<template>
  <div class="card">
    <div class="helloBack">
      <button @click="handleButton">Get Data</button>
      <p>{{ message }}</p>
    </div>
  </div>
</template>

<style scoped>
.card {
  display: flex;
  justify-content: center;
  width: auto;
  height: auto;
  margin: 12px;
  padding: 16px;
  background-color: #ffffff;
  border-radius: 18px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.helloBack {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  background-color: #f9f9f9;
  min-width: 300px;
  padding: 16px;
  border-radius: 16px;
  border: 1px solid black;
}

.helloBack button, .helloBack p {
  margin: 8px;
  text-align: center;
}

</style>
