package com.deepsea.pool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PoolService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> queryUserList(){
        String sql = "select id, user_id, user_name from sys_user where status = '1' order by id";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        return list;
    }
}
