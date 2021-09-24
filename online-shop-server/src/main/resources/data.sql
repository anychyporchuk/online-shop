--USER--
INSERT INTO user (id, first_name, last_name, phone_number, email, password, registered_at)
VALUES(1, 'Artem', 'Nychyporchuk', '888888', 'aa@example.com', '1234', CURRENT_TIMESTAMP());


--PRODUCT--
INSERT INTO product(id, user_id, title, price, created_at, content)
VALUES(1, 1, 'Product 1', 11.43, CURRENT_TIMESTAMP(), 'Product 1 Content'),
      (2, 1, 'Product 2', 14.11, CURRENT_TIMESTAMP(), 'Product 2 Content');

--CATEGORY-
INSERT INTO category(id, parent_id, title, content)
VALUES(1, null, 'Category 1', 'Category 1 Content'),
      (2, null, 'Category 2', 'Category 2 Content'),
      (3, 1, 'Category 1.1', 'Subcategory 1 of Category 1 Content');

--PRODUCT_CATEGORY--
INSERT INTO product_category(product_id, category_id)
VALUES (1, 1);

--PRODUCT_META--
INSERT INTO product_meta(id, product_id, key, value)
VALUES (1, 1, 'Product 1 Key 1', 'Productr 1 Value 1');