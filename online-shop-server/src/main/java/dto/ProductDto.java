package dto;

import lombok.*;

@Data
@EqualsAndHashCode(/*callSuper = true*/)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {
    private Long id;
    private String title;
    private Float price;
    private String content;
    private Long userId;
    //private Set<CategoryDto> categories;
    //private Set<ProductMetaDto> metas;
}
