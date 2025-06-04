package com.myproject.taskmanager.config;

import com.zaxxer.hikari.HikariDataSource;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class EnvConfig {

    @Bean
    public DataSource dataSource() {
        Dotenv dotenv = Dotenv.load();

        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl("jdbc:mysql://" +
                dotenv.get("DB_HOST") + ":" +
                dotenv.get("DB_PORT") + "/" +
                dotenv.get("DB_NAME") + "?createDatabaseIfNotExist=true");
        dataSource.setUsername(dotenv.get("DB_USERNAME"));
        dataSource.setPassword(dotenv.get("DB_PASSWORD"));

        return dataSource;
    }
}