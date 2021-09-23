package com.anck.shop.entity;

public final class SchemaMetadata {
    static final class UserTable {
        static final String TABLENAME = "user";
        static final String ID = "id";
        static final String FIRSTNAME = "firstName";
        static final String LASTNAME = "lastName";
        static final String PHONENUMBER = "phoneNumber";
        static final String EMAIL = "email";
        static final String PASSWORD = "password";
        static final String REGISTEREDAT = "registeredAt";
    }

    static final class ProductTable {
        static final String TABLENAME = "product";
        static final String ID = "id";
        static final String USERID = "userId";
        static final String TITLE = "title";
        static final String CATEGORY = "category";
        static final String PRODUCTMETA = "product_meta";
        static final String PRICE = "price";
        static final String CREATEDAT = "createdAt";
        static final String CONTENT = "content";
    }

    static final class CategoryTable {
        static final String TABLENAME = "category";
        static final String ID = "id";
        static final String PARENTID = "parentId";
        static final String TITLE = "title";
        static final String CONTENT = "content";
    }

    static final class ProductCategoryTable {
        static final String TABLENAME = "product_category";
        static final String PRODUCTID = "productId";
        static final String CATEGORYID = "categoryId";
    }

    static final class ProductMetaTable {
        static final String TABLENAME = "product_meta";
        static final String ID = "id";
        static final String PRODUCTID = "productId";
        static final String KEY = "key";
        static final String VALUE = "value";
    }
}
