package com.anck.shop.entity;

import com.anck.shop.entity.SchemaMetadata.CategoryTable;
import com.anck.shop.entity.SchemaMetadata.ProductCategoryTable;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = CategoryTable.TABLENAME)
public class Category {
    private Long id;
    private Category parentCategory;
    private String title;
    private String content;
    private Set<Category> subCategories;
    private Set<Product> products = new HashSet<>();

    public Category() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = CategoryTable.ID)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = CategoryTable.PARENTID)
    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

    @Column(name = CategoryTable.TITLE)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = CategoryTable.CONTENT)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @OneToMany(mappedBy = "parentCategory")
    public Set<Category> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(Set<Category> subCategories) {
        this.subCategories = subCategories;
    }

    @ManyToMany
    @JoinTable(name = ProductCategoryTable.TABLENAME,
            joinColumns = { @JoinColumn(name = ProductCategoryTable.CATEGORYID) },
            inverseJoinColumns = { @JoinColumn(name = ProductCategoryTable.PRODUCTID) })
    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return id.equals(category.id) && Objects.equals(parentCategory, category.parentCategory) && title.equals(category.title) && content.equals(category.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, parentCategory, title);
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
