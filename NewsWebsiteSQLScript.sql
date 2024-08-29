CREATE DATABASE news_website;

USE news_website;

CREATE TABLE category (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE news (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content TEXT,
    date_published DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE news_category (
    news_id INT,
    category_id INT,
    PRIMARY KEY (news_id, category_id),
    FOREIGN KEY (news_id) REFERENCES news(id),
    FOREIGN KEY (category_id) REFERENCES category(id)
);

CREATE TABLE comment (
    id INT AUTO_INCREMENT PRIMARY KEY,
    news_id INT,
    author VARCHAR(255),
    content TEXT,
    date_posted DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (news_id) REFERENCES news(id)
);
