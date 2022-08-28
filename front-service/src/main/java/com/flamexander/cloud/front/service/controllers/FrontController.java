package com.flamexander.cloud.front.service.controllers;

import com.flamexander.cloud.common.ProductDto;
import com.flamexander.cloud.front.service.services.FrontService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@EnableEurekaClient
@RestController
@RequestMapping("/api/v1/main")
@RequiredArgsConstructor
public class FrontController {
    private final FrontService frontService;

    @GetMapping("/products")
    public List<ProductDto> getProducts(){
        return frontService.getProductsList();
    }

    @GetMapping("/product/{id}")
    public ProductDto getProductById(@PathVariable Long id){
        return frontService.getProductById(id);
    }
}
