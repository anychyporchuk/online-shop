package com.anck.shop.entity;

import javax.persistence.*;

import com.anck.shop.entity.SchemaMetadata.ProductMetaTable;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = SchemaMetadata.ProductMetaTable.TABLENAME)
public class ProductMeta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ProductMetaTable.ID)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = ProductMetaTable.PRODUCTID)
    @ToString.Exclude
    private Product product;

    @Column(name = ProductMetaTable.KEY)
    private String key;

    @Column(name = ProductMetaTable.VALUE)
    private String value;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductMeta that = (ProductMeta) o;
        return id.equals(that.id) && key.equals(that.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, key);
    }
}
