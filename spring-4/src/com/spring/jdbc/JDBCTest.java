package com.spring.jdbc;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

class JDBCTest {
    private ApplicationContext ctx=null;
    private JdbcTemplate jdbcTemplate;
    
    {
    	ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
    	jdbcTemplate=(JdbcTemplate)ctx.getBean("dataSource");
    }
	
	@Test
	public void testDataSource() throws SQLException {
		DataSource dataSource=ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
	}

}
