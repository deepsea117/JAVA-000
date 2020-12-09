package com.geekbang.dao;


import com.geekbang.model.SysOrder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysOrderMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysOrder record);

    int insertSelective(SysOrder record);

    SysOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysOrder record);

    int updateByPrimaryKey(SysOrder record);

    List<SysOrder> selectAllOrder();

}