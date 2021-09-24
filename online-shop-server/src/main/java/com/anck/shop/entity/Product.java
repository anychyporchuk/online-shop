package com.anck.shop.entity;

import com.anck.shop.entity.SchemaMetadata.ProductTable;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = ProductTable.TABLENAME)
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ProductTable.ID)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = ProductTable.USERID)
    @ToString.Exclude
    private User user;

    @Column(name = ProductTable.TITLE)
    private String title;

    @Column(name = ProductTable.PRICE)
    private Float price;

    @CreationTimestamp
    @Column(name = ProductTable.CREATEDAT)
    private LocalDateTime createdAt;

    @Column(name = ProductTable.CONTENT)
    private String content;

    @ManyToMany(mappedBy = "products")
    private Set<Category> categories = new HashSet<>();

    @OneToMany(mappedBy = "product")
    private Set<ProductMeta> metas = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id.equals(product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
