package com.ktko.admin.infra.database;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.ktko.admin.domain.*.repository",
        entityManagerFactoryRef = "ADMIN_ENTITY_MANAGER",
        transactionManagerRef =  "ADMIN_TRANSACTION_MANAGER"
)

@MapperScan(basePackages = "com.ktko.admin.domain.*.mapper.*", annotationClass = Mapper.class, sqlSessionFactoryRef = "SQL_SESSION_FACTORY")
public class BasicDataSourceConfig {

    @Value("${adminDb.url}")
    private String url;

    @Value("${adminDb.userName}")
    private String userName;

    @Value("${adminDb.password}")
    private String password;

    @Value("${adminDb.driverClassName}")
    private String driverClassName;

    @Bean
    public DataSource getDatasource() {
        DataSource datasource = DataSourceBuilder.create().
                driverClassName(driverClassName).url(url).username(userName).password(password).build();

        return datasource;
    }

    @Bean(name = "SQL_SESSION_FACTORY")
    @Primary
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlsessionFactoryBean = new SqlSessionFactoryBean();
        sqlsessionFactoryBean.setDataSource(getDatasource());
        SqlSessionFactory sqlSessionFactory = sqlsessionFactoryBean.getObject();
        sqlSessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true);

        return sqlSessionFactory;
    }


    @Bean(name = "ADMIN_ENTITY_MANAGER")
    @Primary
    public LocalContainerEntityManagerFactoryBean adminEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        localContainerEntityManagerFactoryBean.setDataSource(getDatasource());
        localContainerEntityManagerFactoryBean.setPackagesToScan("com.ktko.admin.domain.*.entity");
        localContainerEntityManagerFactoryBean.setJpaDialect(new HibernateJpaDialect());

        return localContainerEntityManagerFactoryBean;
    }

    @Bean(name = "ADMIN_TRANSACTION_MANAGER")
    @Primary
    public PlatformTransactionManager adminTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(adminEntityManagerFactory().getObject());
        transactionManager.setDefaultTimeout(5);

        return transactionManager;
    }
}
