package com.lambdaschool.bookstore.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class HerokuDatabaseConfig
{

//        @Value("${DATABASE_URL}")
//        private String dbUrl;
//
//        @Bean
//        public DataSource dataSource()
//        {
//            String dbUrl = System.getenv("JDBC_DATABASE_URL");
//            HikariConfig config = new HikariConfig();
//            config.setJdbcUrl(dbUrl);
//            return new HikariDataSource(config);
//        }
}
