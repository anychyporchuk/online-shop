package com.anck.shop.service;

import dto.ProductDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Page<ProductDto> getAllProducts(Pageable paging);
    Page<ProductDto> getProductsByTitle(String title, Pageable paging);
}
