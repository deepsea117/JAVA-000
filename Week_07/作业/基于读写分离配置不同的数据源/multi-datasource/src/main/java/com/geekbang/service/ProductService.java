package com.geekbang.service;

import com.geekbang.model.SysProduct;

import java.util.List;

public interface ProductService {

    List<SysProduct> findAllProductList();

    List<SysProduct> findAllProductListSlave2();

    List<SysProduct> findAllProductListMaster();
}
