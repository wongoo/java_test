package com.sisopipo.test.jdbc_test;

import java.sql.Connection;
import java.sql.SQLException;

import com.sisopipo.jdbc.connection.ConnectionFactory;
import com.sisopipo.jdbc.connection.factory.OracleConnectionFactory;

/**
 * Hello world!
 */
public class App {

	public static void main(String[] args) throws SQLException {
		System.out.println("start test!");
		ConnectionFactory factory = new OracleConnectionFactory();
		Connection connection = factory.create();
		System.out.println("connected:" + (!connection.isClosed()));
	}

}
