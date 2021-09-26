package com.anck.shop.mapper;

import com.anck.shop.entity.ProductMeta;
import dto.ProductMetaDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMetaMapper {
    ProductMetaDto toDto(ProductMeta entity);
    List<ProductMetaDto> map(List<ProductMeta> entities);
}
