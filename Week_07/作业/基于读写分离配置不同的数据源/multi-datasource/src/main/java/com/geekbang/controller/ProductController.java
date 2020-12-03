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

    @GetMapping("/getslave1")
    public List<SysProduct> getslave1(){
        List<SysProduct> sysProductList = productService.findAllProductList();
        return sysProductList;
    }

    @GetMapping("/getslave2")
    public List<SysProduct> getslave2(){
        List<SysProduct> sysProductList = productService.findAllProductListSlave2();
        return sysProductList;
    }

    @GetMapping("/getmaster")
    public List<SysProduct> getmaster(){
        List<SysProduct> sysProductList = productService.findAllProductListMaster();
        return sysProductList;
    }
}
