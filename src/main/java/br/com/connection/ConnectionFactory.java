package br.com.connection;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
	private DataSource dataSoucer;
	
	public ConnectionFactory() {
		ComboPooledDataSource pool = new ComboPooledDataSource();
		try {
			pool.setDriverClass("com.mysql.cj.jdbc.Driver");
		} catch (PropertyVetoException e) {
			throw new RuntimeException();
		}
		pool.setJdbcUrl("jdbc:mysql://localhost/dbagencia?useTimezone=true&serverTimezone=UTC");
		pool.setUser("root");
		pool.setPassword("andrew123");
		pool.setMaxPoolSize(15);
		this.dataSoucer = pool;
	}
	public Connection recuperarConexao() {
		try {
			return this.dataSoucer.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
}
