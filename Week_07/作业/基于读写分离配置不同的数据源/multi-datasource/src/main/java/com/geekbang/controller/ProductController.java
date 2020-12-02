package com.geekbang.controller;

import com.geekbang.model.SysProduct;
import com.geekbang.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/getProductList")
    public List<SysProduct> getProductList(){
        List<SysProduct> sysProductList = productService.findAllProductList();
        return sysProductList;
    }
}
