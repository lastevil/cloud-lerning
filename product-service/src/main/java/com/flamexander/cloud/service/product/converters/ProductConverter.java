package com.flamexander.cloud.service.product.converters;

import com.flamexander.cloud.common.ProductDto;
import com.flamexander.cloud.service.product.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {
    public ProductDto fromEntity(Product product){
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setTitle(product.getTitle());
        productDto.setPrice(product.getPrice());
        return productDto;
    }

    public Product toEntity(ProductDto productDto){
        Product product = new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        return product;
    }

}
