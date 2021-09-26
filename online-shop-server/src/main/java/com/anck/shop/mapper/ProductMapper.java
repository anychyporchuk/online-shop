package com.anck.shop.mapper;

import com.anck.shop.entity.Product;
import dto.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(source = "image", target = "imageUrl")
    ProductDto toDto(Product entity);
    List<ProductDto> map(List<Product> entities);
}
