package com.anck.shop.mapper;

import com.anck.shop.entity.Product;
import dto.ProductDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto toDto(Product entity);
    List<ProductDto> map(List<Product> entities);
}
