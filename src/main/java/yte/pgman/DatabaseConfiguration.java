package yte.pgman;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@EnableTransactionManagement
@Configuration
public class DatabaseConfiguration {
    @Value("${spring.datasource.driver-class-name}")
    private String DB_DRIVER;

    @Value("${spring.datasource.password}")
    private String DB_PASSWORD;

    @Value("${spring.datasource.url}")
    private String DB_URL;

    @Value("${spring.datasource.username}")
    private String DB_USERNAME;

    @Value("${spring.jpa.properties.hibernate.dialect}")
    private String HIBERNATE_DIALECT;


    @Bean
    @Primary
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DB_DRIVER);
        dataSource.setUrl(DB_URL);
        dataSource.setUsername(DB_USERNAME);
        dataSource.setPassword(DB_PASSWORD);

        return dataSource;
    }

    @Bean
    @Primary
    public LocalSessionFactoryBean sessionFactory() throws IOException {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan("tr.gov.tubitak.bilgem.yte.pgman.repository");
        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.dialect", HIBERNATE_DIALECT);
        hibernateProperties.put("hibernate.connection.release_mode", "auto");
        hibernateProperties.put("hibernate.format_sql", true);
        hibernateProperties.put("hibernate.use_sql_comments", true);
        hibernateProperties.put("hibernate.jdbc.use_scrollable_resultset", true);
        hibernateProperties.put("hibernate.jdbc.use_streams_for_binary", true);
        hibernateProperties.put("hibernate.order_inserts", true);
        hibernateProperties.put("hibernate.order_updates", true);
        hibernateProperties.put("hibernate.jdbc.batch_versioned_data ", true);
        hibernateProperties.put("hibernate.cache.region_prefix", "hibernate.cache");
        hibernateProperties.put("hibernate.cache.use_query_cache", false);
        hibernateProperties.put("hibernate.cache.use_second_level_cache", false);
        sessionFactoryBean.setHibernateProperties(hibernateProperties);

        return sessionFactoryBean;
    }


    @Bean(name = "transactionManager")
    @Primary
    public HibernateTransactionManager transactionManager() throws IOException {
        HibernateTransactionManager transactionManager =
                new HibernateTransactionManager(sessionFactory().getObject());
        transactionManager.setDefaultTimeout(600);
        return transactionManager;
    }
}