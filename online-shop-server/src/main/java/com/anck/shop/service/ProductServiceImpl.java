package com.anck.shop.service;

import com.anck.shop.entity.Product;
import com.anck.shop.mapper.ProductMapper;
import com.anck.shop.repository.ProductRepository;
import dto.ProductDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Page<ProductDto> getAllProducts(Pageable paging) {
        Page<Product> products =  productRepository.findAll(paging);
        return new PageImpl<ProductDto>(productMapper.map(products.getContent()), paging, products.getTotalElements());
    }
}
