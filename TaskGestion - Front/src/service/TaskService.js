import axios from "axios";

const API_URL = "http://localhost:8080/api/tasks"

const addTask = (data) => {
    return axios.post(API_URL, data);
};

const getTasks = () => {
    return axios.get(API_URL + "/getTasks");
}

const getTaskById = (idTask) => {
    return axios.get(API_URL + "/" + idTask);
}

const updateTask = (data, idTask) => {
    return axios.put(API_URL + "/" + idTask, data);
};

const removeTask = (idTask) => {
    return axios.delete(API_URL + "/" + idTask)
}

const TaskService = {
    addTask,
    getTasks,
    getTaskById,
    updateTask,
    removeTask,
}

export default TaskService;