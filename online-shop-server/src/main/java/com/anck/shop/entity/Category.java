package com.anck.shop.entity;

import com.anck.shop.entity.SchemaMetadata.CategoryTable;
import com.anck.shop.entity.SchemaMetadata.ProductCategoryTable;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
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
@Table(name = CategoryTable.TABLENAME)
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = CategoryTable.ID)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = CategoryTable.PARENTID)
    @ToString.Exclude
    private Category parentCategory;

    @Column(name = CategoryTable.TITLE)
    private String title;

    @Column(name = CategoryTable.CONTENT)
    private String content;

    @OneToMany(mappedBy = "parentCategory", fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<Category> subCategories;

    @ManyToMany
    @JoinTable(name = ProductCategoryTable.TABLENAME,
            joinColumns = { @JoinColumn(name = ProductCategoryTable.CATEGORYID) },
            inverseJoinColumns = { @JoinColumn(name = ProductCategoryTable.PRODUCTID) })
    @ToString.Exclude
    private Set<Product> products = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return id.equals(category.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
