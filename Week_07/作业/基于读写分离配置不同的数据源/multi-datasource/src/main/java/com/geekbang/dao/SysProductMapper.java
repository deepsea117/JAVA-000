package com.geekbang.dao;

import com.geekbang.model.SysProduct;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysProductMapper {

    int deleteByPrimaryKey(Long pdId);

    int insert(SysProduct record);

    int insertSelective(SysProduct record);

    SysProduct selectByPrimaryKey(Long pdId);

    int updateByPrimaryKeySelective(SysProduct record);

    int updateByPrimaryKey(SysProduct record);

    List<SysProduct> selectAllProductList();
}