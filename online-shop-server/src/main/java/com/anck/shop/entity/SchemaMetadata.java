package com.anck.shop.entity;

public final class SchemaMetadata {
    static final class UserTable {
        static final String TABLENAME = "user";
        static final String ID = "id";
        static final String FIRSTNAME = "first_name";
        static final String LASTNAME = "last_name";
        static final String PHONENUMBER = "phone_number";
        static final String EMAIL = "email";
        static final String PASSWORD = "password";
        static final String REGISTEREDAT = "registered_at";
    }

    static final class ProductTable {
        static final String TABLENAME = "product";
        static final String ID = "id";
        static final String USERID = "user_id";
        static final String TITLE = "title";
        static final String CATEGORY = "category";
        static final String PRODUCTMETA = "product_meta";
        static final String PRICE = "price";
        static final String CREATEDAT = "created_at";
        static final String CONTENT = "content";
    }

    static final class CategoryTable {
        static final String TABLENAME = "category";
        static final String ID = "id";
        static final String PARENTID = "parent_id";
        static final String TITLE = "title";
        static final String CONTENT = "content";
    }

    static final class ProductCategoryTable {
        static final String TABLENAME = "product_category";
        static final String PRODUCTID = "product_id";
        static final String CATEGORYID = "category_id";
    }

    static final class ProductMetaTable {
        static final String TABLENAME = "product_meta";
        static final String ID = "id";
        static final String PRODUCTID = "product_id";
        static final String KEY = "key";
        static final String VALUE = "value";
    }
}
