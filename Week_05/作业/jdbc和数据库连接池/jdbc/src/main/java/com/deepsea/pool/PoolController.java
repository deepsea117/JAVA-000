package com.deepsea.pool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class PoolController {

    @Autowired
    private PoolService poolService;

    @GetMapping("/findUserList")
    public List<Map<String, Object>> findUserList(){
        List<Map<String, Object>> list = poolService.queryUserList();
        return list;
    }
}
