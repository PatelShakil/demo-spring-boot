package com.springdemo.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

@Configuration
public class DBConfig {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    //your own class => object => stereotype annotations
    //configuration, controller, service, repository, component


    //library class => object => bean method
    @Bean
    public JdbcTemplate jdbcTemplate(){
        SingleConnectionDataSource sc = new SingleConnectionDataSource(
                url, username, password, true
        );
        return new JdbcTemplate(sc);
    }
}
