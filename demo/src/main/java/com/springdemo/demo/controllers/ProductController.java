package com.springdemo.demo.controllers;

import com.springdemo.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product") // this now matches your request
    public List<String> products(@RequestParam(name = "name", required = true) String prod) {
        return productService.getProducts(prod);
    }
}
