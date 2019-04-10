package com.Metro.Intilizer;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import static org.hibernate.cfg.Environment.*;

@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScans(value={@ComponentScan("com.Metro.DAO"),
		@ComponentScan("com.Metro.Service")})
 
public class HibernateConfig {
		
	@Autowired
	private Environment env;
	
@Bean
public DataSource datasource(){
	DriverManagerDataSource ds=new DriverManagerDataSource();
	ds.setDriverClassName(env.getProperty("Oracle.driver"));
	ds.setUrl(env.getProperty("Oracle.url"));
	ds.setUsername(env.getProperty("Oracle.user"));
	ds.setPassword(env.getProperty("Oracle.password"));	
	return ds;
}
	

@Bean
public LocalSessionFactoryBean getsession(DataSource ds){
	LocalSessionFactoryBean sf=new LocalSessionFactoryBean();
	 Properties pro=new Properties();
	 pro.put(DIALECT,env.getProperty("hibernate.dialect"));
     pro.put(SHOW_SQL,env.getProperty("hibernate.show_sql"));
	 pro.put(HBM2DDL_AUTO,env.getProperty("hibernate.hbm2ddl.auto"));
	sf.setHibernateProperties(pro);
	sf.setDataSource(ds);
	sf.setPackagesToScan("com.Metro.BookModel");
	return sf;
	
}


@Bean
public HibernateTransactionManager gethibernate(SessionFactory sf){
	HibernateTransactionManager tx=new HibernateTransactionManager(sf);	
	return tx;
	
}
@Bean
public HibernateTemplate hibernateTemplate(SessionFactory sf){
	HibernateTemplate htemp=new HibernateTemplate(sf);
	return htemp;
}


}
