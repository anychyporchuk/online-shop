package dto;

import lombok.*;

import java.util.List;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {
    private Long id;
    private String title;
    private Float price;
    private String content;
    private String imageUrl;
    private List<ProductMetaDto> metas;
}
