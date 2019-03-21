//package org.rabbit.config;
//
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Primary;
//
//import javax.sql.DataSource;
//
//public class OracleConfig {
//
//    @Bean
//    @Primary
//    @ConfigurationProperties(prefix="spring.datasource")
//    public DataSource primaryDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//
//    @Bean
//    @ConfigurationProperties(prefix="spring.secondDatasource")
//    public DataSource secondaryDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//}
