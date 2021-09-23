DROP TABLE IF EXISTS user;
CREATE TABLE user (
    id BIGINT IDENTITY PRIMARY KEY,
    firstName VARCHAR(100),
    lastName VARCHAR(100),
    phoneNumber VARCHAR(15) UNIQUE,
    email VARCHAR(50) UNIQUE,
    password VARCHAR(32) NOT NULL,
    registeredAt DATE NOT NULL
);


DROP TABLE IF EXISTS product;
CREATE TABLE product (
    id BIGINT IDENTITY PRIMARY KEY,
    userId BIGINT NOT NULL,
    title VARCHAR(100) NOT NULL,
    type SMALLINT NOT NULL DEFAULT 0,
    price FLOAT NOT NULL DEFAULT 0,
    createdAt DATE NOT NULL,
    content CLOB,
    CONSTRAINT fk_product_user FOREIGN KEY (userId) REFERENCES user (id)
);

DROP TABLE IF EXISTS product_meta;
CREATE TABLE product_meta (
    id BIGINT IDENTITY PRIMARY KEY,
    productId BIGINT NOT NULL,
    key VARCHAR(50) NOT NULL,
    value CLOB,
    CONSTRAINT fk_meta_product FOREIGN KEY (productId) REFERENCES product (id)
);

DROP TABLE IF EXISTS category;
CREATE TABLE category (
    id BIGINT IDENTITY PRIMARY KEY,
    parentId BIGINT,
    title varchar(75) NOT NULL,
    content CLOB,
    CONSTRAINT fk_category_parent FOREIGN KEY (parentId) REFERENCES category (id)
);

DROP TABLE product_category IF EXISTS;
CREATE TABLE product_category (
    productId BIGINT NOT NULL,
    categoryId BIGINT NOT NULL,
    CONSTRAINT fk_pc_product FOREIGN KEY (productId) REFERENCES product (id),
    CONSTRAINT fk_pc_category FOREIGN KEY (categoryId) REFERENCES category (id)
)