package com.niit.collaboration.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.collaboration.dao.UserDao;
import com.niit.collaboration.daoimpl.UserDaoImpl;

@Configuration
@ComponentScan(basePackages = "com.nii.collaboration")
@EnableTransactionManagement
public class ApplicationContextConfig {
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		System.out.println("h1");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		dataSource.setUsername("COLLBORATION");
		dataSource.setPassword("password");
		return dataSource;
		
	}



	private Properties getHibernateProperties() {
		
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		properties.put("hibernate.hbm2ddl.auto","create");
		return properties;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		
		System.out.println("session");
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		//sessionBuilder.addAnnotatedClass(User.class);
		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		
		System.out.println("tran");
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		System.out.println("tran end");
		return transactionManager;
	}

	@Autowired
    @Bean(name = "userDAO")
    public UserDao getUserDao(SessionFactory sessionFactory) 
	{
		System.out.println("userdao");
    	return new UserDaoImpl(sessionFactory);
    }
	
	;
	
	
}