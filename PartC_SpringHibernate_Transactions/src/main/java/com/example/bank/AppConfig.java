package com.example.bank;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration as SpringConfig;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringConfig
@EnableTransactionManagement
public class AppConfig {
    @Bean
    public SessionFactory sessionFactory() {
        return new Configuration().configure().addAnnotatedClass(Account.class).buildSessionFactory();
    }

    @Bean
    public BankService bankService() {
        return new BankService(sessionFactory());
    }

    @Bean
    public PlatformTransactionManager txManager() {
        return new HibernateTransactionManager(sessionFactory());
    }
}
