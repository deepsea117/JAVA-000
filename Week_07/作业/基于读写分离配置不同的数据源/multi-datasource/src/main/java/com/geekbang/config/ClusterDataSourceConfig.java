package com.geekbang.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

//@Configuration
public class ClusterDataSourceConfig {

    @Value("${spring.datasource.db2.url}")
    private String url;
    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;
    @Value("${spring.datasource.db2.username}")
    private String username;
    @Value("${spring.datasource.db2.password}")
    private String password;


    @Bean("clusterDataSource")
    public DataSource clusterDataSource(){
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setJdbcUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }



    @Bean("clusterTransactionManager")
    public DataSourceTransactionManager clusterTransactionManager(){
        return new DataSourceTransactionManager(clusterDataSource());
    }
}
