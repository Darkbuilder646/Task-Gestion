import axios from "axios";

const API_URL = "http://localhost:8080/api/auth"

const register = (username, email, password) => {
    return axios.post(API_URL + "/signup", {
        username,
        email,
        password,
    });
};

const login = (email, password) => {
    return axios.post(API_URL + "/login", {
        email,
        password,
    });
}

const AuthService = {
    register,
    login,
}

export default AuthService;