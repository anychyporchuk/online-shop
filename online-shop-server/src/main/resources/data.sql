--USER--
INSERT INTO user (id, firstName, lastName, phoneNumber, email, password, registeredAt)
VALUES(1, 'Artem', 'Nychyporchuk', '888888', 'aa@example.com', '1234', CURRENT_TIMESTAMP());


--PRODUCT--
INSERT INTO product(id, userId, title, price, createdAt, content)
VALUES(1, 1, 'Product 1', 11.43, CURRENT_TIMESTAMP(), 'Product 1 Content'),
      (2, 1, 'Product 2', 14.11, CURRENT_TIMESTAMP(), 'Product 2 Content');

--CATEGORY-
INSERT INTO category(id, parentId, title, content)
VALUES(1, null, 'Category 1', 'Category 1 Content'),
      (2, null, 'Category 2', 'Category 2 Content'),
      (3, 1, 'Category 1.1', 'Subcategory 1 of Category 1 Content');

--PRODUCT_CATEGORY--
INSERT INTO product_category(productId, categoryId)
VALUES (1, 1);

--PRODUCT_META--
INSERT INTO product_meta(id, productId, key, value)
VALUES (1, 1, 'Product 1 Key 1', 'Productr 1 Value 1');