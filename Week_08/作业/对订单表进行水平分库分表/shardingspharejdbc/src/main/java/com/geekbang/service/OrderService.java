package com.geekbang.service;


import com.geekbang.dao.SysOrderMapper;
import com.geekbang.model.SysOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private SysOrderMapper sysOrderMapper;


    public void insertOrder(SysOrder sysOrder) {
        sysOrderMapper.insertSelective(sysOrder);
    }


    public List<SysOrder> getAllOrder() {
        List<SysOrder> sysOrderList = sysOrderMapper.selectAllOrder();
        return sysOrderList;
    }

    public SysOrder getOrderById(Long id) {
        SysOrder sysOrder = sysOrderMapper.selectByPrimaryKey(id);
        return sysOrder;
    }


    public void updateOrder(SysOrder sysOrder) {
        sysOrderMapper.updateByPrimaryKey(sysOrder);
    }

    public void delOrderById(Long id) {
        sysOrderMapper.deleteByPrimaryKey(id);
    }
}
