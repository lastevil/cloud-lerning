package com.flamexander.cloud.front.service.services;

import com.flamexander.cloud.common.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FrontService {
   private final RestTemplate restTemplate;

    public ProductDto getProductById(Long id) {
        ProductDto data = restTemplate.getForObject("http://product-service/api/v1/products/" + id, ProductDto.class);
        return data;
    }

    public List<ProductDto> getProductsList() {
        List<ProductDto> data = restTemplate.getForObject("http://product-service/api/v1/products", List.class);
        return data;
    }
}
