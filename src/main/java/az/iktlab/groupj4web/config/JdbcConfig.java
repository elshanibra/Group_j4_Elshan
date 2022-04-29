package az.iktlab.groupj4web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class JdbcConfig {

    @Bean
    @Scope(value = "prototype")
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("");
    }
}