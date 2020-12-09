package com.geekbang.controller;

import com.geekbang.model.SysOrder;
import com.geekbang.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/insertOrderSharding")
    public String insertOrderSharding(){
        System.out.println("订单生成开始----------------------------");
        for(int i=0; i<500; i++){
            SysOrder sysOrder = new SysOrder();
            sysOrder.setUserName("sharding_"+i);
            sysOrder.setUserId(Long.valueOf(i));
            sysOrder.setCreateTime(new Date().getTime());
            sysOrder.setUpdateTime(new Date().getTime());
            sysOrder.setStatus(1);
            sysOrder.setPrice(new BigDecimal(i));
            orderService.insertOrder(sysOrder);
        }
        return "订单生成结束";
    }

    @GetMapping("/getAllOrder")
    public List<SysOrder> getAllOrder(){
        List<SysOrder> sysOrderList = orderService.getAllOrder();
        return sysOrderList;
    }

    @GetMapping("/queryOrderById")
    public SysOrder queryOrderById(){
        Long id = 543545655381983232L;
        SysOrder sysOrder = orderService.getOrderById(id);
        return sysOrder;
    }

    @GetMapping("/updateOrder")
    public void updateOrder(){
        SysOrder sysOrder = orderService.getOrderById(543545655679778817L);
        sysOrder.setCreateTime(new Date().getTime());
        sysOrder.setStatus(2);
        orderService.updateOrder(sysOrder);

    }

    @GetMapping("/delOrder")
    public void delOrder(){
        Long id = 543545655767859200L;
        orderService.delOrderById(id);
    }
}
