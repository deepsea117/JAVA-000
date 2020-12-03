package com.geekbang.service.impl;

import com.geekbang.annotation.DataSource;
import com.geekbang.dao.SysProductMapper;
import com.geekbang.model.SysProduct;
import com.geekbang.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private SysProductMapper sysProductMapper;


    @Override
    public List<SysProduct> findAllProductList() {
        List<SysProduct> sysProductList = sysProductMapper.selectAllProductListSlave1();
        return sysProductList;
    }

    @Override
    public List<SysProduct> findAllProductListSlave2() {
        List<SysProduct> sysProductList = sysProductMapper.selectAllProductListSlave2();
        return sysProductList;
    }

    @Override
    public List<SysProduct> findAllProductListMaster() {
        List<SysProduct> sysProductList = sysProductMapper.selectAllProductList();
        return sysProductList;
    }
}
