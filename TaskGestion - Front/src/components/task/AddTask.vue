<script setup>
import TaskService from "@/service/TaskService";
import { ref, onMounted } from "vue";

const tasks = ref([]);

const fetchAllTasks = async () => {
  try {
    const response = await TaskService.getTasks();
    tasks.value = response.data;
  } catch (error) {
    console.error("Error fetching tasks:", error);
  }
};

onMounted(() => {
  fetchAllTasks();
});
</script>

<script>
import TaskService from "@/service/TaskService";
import TaskCard from "@/components/task/TaskCard.vue";
import { ref } from 'vue'; 

const task = ref({
  id: Number,
  tag: "",
  description: "",
});

const onSubmit = () => {
  if(!task.value.tag) { task.value.tag = "other" }
  handleAddTask(task.value);
};

const handleAddTask = (data) => {
  TaskService.addTask(data)
    .then(async (res) => {
      console.log("Response : " + res.data);
      clearInput();
      await fetchAllTasks();
    })
    .catch((error) => {
      console.log("Error : " + error);
    });
};

const fetchAllTasks = async () => {
  try {
    const response = await TaskService.getTasks();
    console.log(response.data);
    task.value = response.data; 
    location.reload();
  } catch (error) {
    console.error("Error fetching tasks:", error);
  }
};

const clearInput = () => {
  task.value.tag = "";
  task.value.description = "";
};

</script>

<template>
  <div class="container">
    <form class="formTask" @submit.prevent="onSubmit">
      <label for="tagTask">Tag :</label>
      <select name="tagTask" id="tag" v-model="task.tag">
        <option value="">---- Select a tag ----</option>
        <option value="frontend">Frontend</option>
        <option value="backend">Backend</option>
        <option value="deployment">Deployment</option>
        <option value="organization">Organization</option>
        <option value="Test Unit">Test Unit</option>
      </select>
      <label for="taskDesc">Task :</label>
      <input
        type="text"
        name="taskDesc"
        id="task"
        required
        v-model="task.description"
      />
      <button type="submit">Add</button>
    </form>
    <button class="clearButton" @click="clearInput">Clear</button>
  </div>
  <div class="taskContainer">
    <TaskCard
      v-for="task in tasks"
      :key="task.id"
      :id="task.id"
      :tag="task.tag"
      :description="task.description"
    />
  </div>
</template>

<style scoped>
.taskContainer {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.container {
  margin: 20px;
  padding-top: 20px;
  display: flex;
  justify-content: center;
}

.formTask {
  display: flex;
  flex-direction: row;
  align-items: center;
}

.formTask label {
  margin-right: 10px;
}

.formTask input,
.formTask select {
  padding: 5px;
  margin-right: 20px;
  border-radius: 5px;
  border: 1px solid #ccc;
}

#tag {
  width: 150px;
}

#task {
  width: 350px;
}

.formTask button,
.clearButton {
  width: 74px;
  padding: 8px 12px;
  margin-right: 10px;
  border-radius: 5px;
  background-color: #007bff;
  color: #fff;
  border: none;
  cursor: pointer;
}

.formTask button:hover {
  background-color: #0056b3;
}

.clearButton {
  margin-right: 0;
  background-color: #dc3545;
}

.clearButton:hover {
  background-color: #bd2130;
}
</style>
