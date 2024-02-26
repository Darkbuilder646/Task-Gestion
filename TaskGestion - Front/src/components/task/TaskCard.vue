<script>
import TaskService from "@/service/TaskService";
export default {
  props: {
    id: Number,
    tag: String,
    description: String,
  },
  computed: {
    tagColor() {
      switch (this.tag.toLowerCase()) {
        case "frontend":
          return "#007bff";
        case "backend":
          return "#c55cfa";
        case "deployment":
          return "#0da6c8";
        case "organization":
          return "#d98321";
        case "test unit":
          return "#32a727";
        default:
          return "#7e7e7e";
      }
    },
  },
  methods: {
    deleteTask() {
      console.log("This task's id is : " + this.id);
      this.handleRemoveTask(this.id)
    },
    handleRemoveTask(id) {
      TaskService.removeTask(id)
      .then(() => {
        console.log("Task removed with success");
        location.reload();
      })
      .catch((error) => {
        console.log("Error : " + error);
      })
    }
  },
};
</script>

<template>
  <div class="taskCard">
    <p class="tag" :style="{ backgroundColor: tagColor }">{{ tag }}</p>
    <p class="desc">{{ description }}</p>
    <input type="checkbox" class="checkbox" />
    <button class="deleteButton" @click="deleteTask">Clear</button>
  </div>
</template>

<style scoped>
.taskCard {
  display: flex;
  align-items: center;
  height: auto;
  width: 700px;
  background-color: #ffffff;
  margin-bottom: 20px;
  padding: 12px;
  border-radius: 20px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.15);
}

.tag {
  width: 150px;
  text-align: center;
  padding: 6px 12px;
  border-radius: 12px;
  color: #ffffff;
  margin-right: 12px;
}

.desc {
  flex: 1;
}

.checkbox {
  width: 16px;
  height: 16px;
  margin: 0 12px;
}

.taskCard button {
  padding: 8px 12px;
  border-radius: 8px;
  background-color: #dc3545;
  color: white;
  border: none;
  cursor: pointer;
}
.taskCard button:hover {
  background-color: #bd2130;
}
</style>
