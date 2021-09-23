package com.anck.shop.entity;

import javax.persistence.*;

import com.anck.shop.entity.SchemaMetadata.ProductMetaTable;

import java.util.Objects;

@Entity
@Table(name = SchemaMetadata.ProductMetaTable.TABLENAME)
public class ProductMeta {
    private Long id;
    private Product product;
    private String key;
    private String value;

    public ProductMeta() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ProductMetaTable.ID)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = ProductMetaTable.PRODUCTID)
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Column(name = ProductMetaTable.KEY)
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Column(name = ProductMetaTable.VALUE)
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductMeta that = (ProductMeta) o;
        return id.equals(that.id) && product.equals(that.product) && key.equals(that.key) && value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, key, value);
    }

    @Override
    public String toString() {
        return "ProductMeta{" +
                "id=" + id +
                ", product=" + product +
                ", key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
