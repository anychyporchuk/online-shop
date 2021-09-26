package com.anck.shop.controller;

import com.anck.shop.service.ProductService;
import dto.ProductDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/")
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getAllProducts(
            @RequestParam(defaultValue = "") String title,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int limit
    ) {
        if(StringUtils.isBlank(title)) {
            return new ResponseEntity<>(productService.getAllProducts(PageRequest.of(page, limit)).getContent(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(productService.getProductsByTitle(title, PageRequest.of(page, limit)).getContent(), HttpStatus.OK);
        }

    }
}
