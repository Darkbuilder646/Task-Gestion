-- DROP TABLE IF EXISTS users_roles;
-- DROP TABLE IF EXISTS users;
-- DROP TABLE IF EXISTS roles;
-- DROP TABLE IF EXISTS tasks;

-- CREATE TABLE users (
--     id INT AUTO_INCREMENT PRIMARY KEY,
--     username VARCHAR(250) NOT NULL,
--     email VARCHAR(250) NOT NULL,
--     password VARCHAR(250) NOT NULL
-- );

-- INSERT INTO users (username, email, password) VALUES
--     ('admin', 'admin@gmail.com', 'admin'),
--     ('guest', 'guest@gmail.com', 'guest1234'),
--     ('bob', 'bob@gmail.com', 'bobTheBest59');

-- CREATE TABLE roles (
--     id INT AUTO_INCREMENT PRIMARY KEY,
--     name VARCHAR(250) NOT NULL
-- );

-- INSERT INTO roles (name) VALUES
--     ('USER'),
--     ('ADMIN'),
--     ('MANAGER');

-- CREATE TABLE users_roles (
--     user_id INTEGER NOT NULL,
--     role_id INTEGER NOT NULL,
--     FOREIGN KEY(user_id) REFERENCES users(id),
--     FOREIGN KEY(role_id) REFERENCES roles(id),
--     PRIMARY KEY (user_id, role_id)
-- );

-- INSERT INTO users_roles (user_id, role_id) VALUES
--     (1,2),
--     (2,1),
--     (2,2),
--     (2,3),
--     (3,1);

-- CREATE TABLE tasks (
--     id INT AUTO_INCREMENT PRIMARY KEY,
--     tag VARCHAR(250) NOT NULL,
--     description VARCHAR(250) NOT NULL
-- );

-- INSERT INTO tasks (tag, description) VALUES
--     ('Fix bugs', 'Fix some bugs in frontend in call of action button'),
--     ('Docker', 'Deploy the app with Docker'),
--     ('Test Units', 'Test API in backend and security');
