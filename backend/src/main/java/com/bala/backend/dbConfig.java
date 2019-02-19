package com.bala.backend;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.bala")
@EnableTransactionManagement
public class dbConfig 
{
	

	@Bean("mydatasource")
	DataSource getDataSource() 
	{

		BasicDataSource basicDataSource = new BasicDataSource();// DriverManagerDataSource can be used
		basicDataSource.setDriverClassName("org.h2.Driver");
		basicDataSource.setUrl("jdbc:h2:~/project");
		basicDataSource.setUsername("sa");
		basicDataSource.setPassword("sa");
		return basicDataSource;
	}

	// 2) lang understood by database(keywords)distinct/unique
	@Bean("myproperties")
	Properties myDbProperties() {
		Properties properties = new Properties();// hashmap
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");// crud--dml
		properties.setProperty("hibernate.hbm2ddl.auto", "update");// creating ur data structure
		properties.setProperty("hibernate.show_sql", "true");
		return properties;
	}

// 3) with the help of above config we will establish a connection

	@Autowired
	@Bean("sessionfactory")
	LocalSessionFactoryBean createSessionFactory(DataSource mydatasource, Properties myproperties) {
		// orm to create the queries
		LocalSessionFactoryBean lSessionFactorybean = new LocalSessionFactoryBean();
		lSessionFactorybean.setDataSource(mydatasource);
		lSessionFactorybean.setHibernateProperties(myproperties);
		lSessionFactorybean.setPackagesToScan("com.bala.backend.model");// package name where my pojo
		return lSessionFactorybean;
	}

	@Autowired
	@Bean
	HibernateTransactionManager htm(SessionFactory sessionfactory) {

		HibernateTransactionManager htmanager = new HibernateTransactionManager();
		htmanager.setSessionFactory(sessionfactory);
		return htmanager;

	}

}
