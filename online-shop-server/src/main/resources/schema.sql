DROP TABLE IF EXISTS user;
CREATE TABLE user (
    id BIGINT IDENTITY PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    phone_number VARCHAR(15) UNIQUE,
    email VARCHAR(50) UNIQUE,
    password ARRAY NOT NULL,
    registered_at TIMESTAMP NOT NULL
);


DROP TABLE IF EXISTS product;
CREATE TABLE product (
    id BIGINT IDENTITY PRIMARY KEY,
    user_id BIGINT NOT NULL,
    title VARCHAR(100) NOT NULL,
    price FLOAT NOT NULL DEFAULT 0,
    created_at TIMESTAMP NOT NULL,
    content CLOB,
    CONSTRAINT fk_product_user FOREIGN KEY (user_id) REFERENCES user (id)
);

DROP TABLE IF EXISTS product_meta;
CREATE TABLE product_meta (
    id BIGINT IDENTITY PRIMARY KEY,
    product_id BIGINT NOT NULL,
    key VARCHAR(50) NOT NULL,
    value CLOB,
    CONSTRAINT fk_meta_product FOREIGN KEY (product_id) REFERENCES product (id)
);

DROP TABLE IF EXISTS category;
CREATE TABLE category (
    id BIGINT IDENTITY PRIMARY KEY,
    parent_id BIGINT,
    title varchar(75) NOT NULL,
    content CLOB,
    CONSTRAINT fk_category_parent FOREIGN KEY (parent_id) REFERENCES category (id)
);

DROP TABLE product_category IF EXISTS;
CREATE TABLE product_category (
    product_id BIGINT NOT NULL,
    category_id BIGINT NOT NULL,
    CONSTRAINT fk_pc_product FOREIGN KEY (product_id) REFERENCES product (id),
    CONSTRAINT fk_pc_category FOREIGN KEY (category_id) REFERENCES category (id)
)