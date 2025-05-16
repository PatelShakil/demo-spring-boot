package com.springdemo.demo.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    public List<String> getProducts(String prod) {
        List<String> products = new ArrayList<String>();
        products.add("Apple");
        products.add("Banana");
        return products;
    }
}
