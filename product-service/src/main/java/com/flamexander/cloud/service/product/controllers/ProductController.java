package com.flamexander.cloud.service.product.controllers;

import com.flamexander.cloud.common.ProductDto;
import com.flamexander.cloud.service.product.converters.ProductConverter;
import com.flamexander.cloud.service.product.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@EnableEurekaClient
public class ProductController {
    private final ProductService productService;
    private final ProductConverter productConverter;

    @GetMapping
    public List<ProductDto> findAll() {
        return productService.findAll()
                .stream()
                .map(productConverter::fromEntity).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable Long id) {
        return productConverter.fromEntity(productService.findById(id).orElseThrow());
    }
}
