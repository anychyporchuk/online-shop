package com.anck.shop.entity;

import javax.persistence.*;

import com.anck.shop.entity.SchemaMetadata.ProductTable;

import java.util.*;

@Entity
@Table(name = ProductTable.TABLENAME)
public class Product {
    private Long id;
    private User user;
    private String title;
    private Float price;
    private Date createdAt;
    private String content;
    private Set<Category> categories = new HashSet<>();
    private Set<ProductMeta> metas = new HashSet<>();

    public Product() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ProductTable.ID)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = ProductTable.USERID)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Column(name = ProductTable.TITLE)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = ProductTable.PRICE)
    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Column(name = ProductTable.CREATEDAT)
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Column(name = ProductTable.CONTENT)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @ManyToMany(mappedBy = "products")
    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    @OneToMany(mappedBy = "product")
    public Set<ProductMeta> getMetas() {
        return metas;
    }

    public void setMetas(Set<ProductMeta> metas) {
        this.metas = metas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id.equals(product.id) && user.equals(product.user) && title.equals(product.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, title);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", user=" + user +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", createdAt=" + createdAt +
                ", content='" + content + '\'' +
                ", metas=" + metas +
                '}';
    }
}
