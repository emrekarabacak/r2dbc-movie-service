package com.ekarabacak.r2dbcmoveservice.config;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConnectionFactoryConfiguration {

    @Bean
    ConnectionFactory connectionFactory() {

        PostgresqlConnectionConfiguration configuration =
                PostgresqlConnectionConfiguration.builder()
                        .host("localhost")
                        .username("user")
                        .password("pass")
                        .database("test")
                        .build();

        return new PostgresqlConnectionFactory(configuration);
    }
}
