package com.example.gradleTest1;

import javax.sql.DataSource;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class config {
	@Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://krdrive.ipdisk.co.kr:3306/apple");
        dataSource.setUsername("apple");
        dataSource.setPassword("123123");
        return dataSource;
    }
	 @Bean
	    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
	        return new JdbcTemplate(dataSource);
	 }
}
