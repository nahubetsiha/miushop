package com.ea.miushop.service.impl;

import com.ea.miushop.domain.Product;
import com.ea.miushop.repository.ProductRepository;
import com.ea.miushop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.getOne(id);
    }

    @Override
    public void createProduct(Product product) {
        productRepository.save(product);
    }
}
