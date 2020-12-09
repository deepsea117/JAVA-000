package com.geekbang.service;

import com.geekbang.dao.SysProductMapper;
import com.geekbang.model.SysProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private SysProductMapper sysProductMapper;

    public List<SysProduct> findAllProductListMaster() {
        List<SysProduct> sysProductList = sysProductMapper.selectAllProductList();
        return sysProductList;
    }


}
