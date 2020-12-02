package com.geekbang.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

//@Configuration
public class MasterDataSourceConfig {

    @Value("${spring.datasource.master.url}")
    private String url;
    @Value("${spring.datasource.master.driverClassName}")
    private String driverClassName;
    @Value("${spring.datasource.master.username}")
    private String username;
    @Value("${spring.datasource.master.password}")
    private String password;

    @Primary
    @Bean("masterDataSource")
    public DataSource masterDataSource(){
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setJdbcUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }


    @Primary
    @Bean("masterTransactionManager")
    public DataSourceTransactionManager masterTransactionManager(){
        return new DataSourceTransactionManager(masterDataSource());
    }
}
