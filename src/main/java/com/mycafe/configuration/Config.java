package com.mycafe.configuration;

import com.mycafe.dao.*;
import com.mycafe.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class Config {
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.mycafe.model");

        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto","update");
        hibernateProperties.setProperty("dialect","org.hibernate.dialect.H2Dialect");
        sessionFactory.setHibernateProperties(hibernateProperties);

        return sessionFactory;
    }

    @Bean
    public DataSource dataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:mycafe;MODE=MySQL;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");
        dataSource.setUsername("sa");
        dataSource.setPassword("");

        return dataSource;

//        return DataSourceBuilder.create().driverClassName("org.h2.Driver")
//                .username("sa").password("")
//                .url("jdbc:h2:mem:mycafe").build();
    }

    @Bean
    @Primary
    public FoodRepositoryDAO getFoodRepositoryDao(){
        return new FoodRepositoryDaoImpl();
    }

    @Bean
    @Primary
    public FoodService getFoodServiceImpl(){ return new FoodServiceImpl(); }

    @Bean
    @Primary
    public FoodOrderDAO getOrderDao() { return new FoodOrderDAOImpl(); }

    @Bean
    @Primary
    public FoodOrderService orderService() { return new FoodOrderServiceImpl(); }

    @Bean
    @Primary
    public CustomerDAO customerDAO() { return new CustomerDAOImpl(); }

    @Bean
    @Primary
    public PlacedOrderDAO placedOrderDAO() { return new PlacedOrderDAOImpl(); }

    @Bean
    @Primary
    public PlacedOrderService placedOrderService() { return new PlacedOrderServiceImpl(); }

    @Bean
    @Primary
    public FoodCategoryDAO foodCategoryDAO() { return new FoodCategoryDAOmpl(); }

    @Bean
    @Primary
    public FoodCategoryService foodCategoryService() { return new FoodCategoryServiceImpl(); }

//    @Bean
//    public InternalResourceViewResolver getInternalResourceViewResolver(){
//        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//        viewResolver.setSuffix(".jsp");
//        viewResolver.setPrefix("views/");
//        return viewResolver;
//    }
}
