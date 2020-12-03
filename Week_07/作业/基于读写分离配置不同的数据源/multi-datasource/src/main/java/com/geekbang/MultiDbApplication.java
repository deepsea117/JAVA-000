package com.geekbang;

import com.geekbang.config.DynamicDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@MapperScan("com.geekbang.dao")
@Import(DynamicDataSourceRegister.class)
public class MultiDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultiDbApplication.class, args);
    }
}
