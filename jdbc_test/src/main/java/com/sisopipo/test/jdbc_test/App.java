package com.sisopipo.test.jdbc_test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.sisopipo.jdbc.connection.ConnectionFactory;
import com.sisopipo.jdbc.connection.factory.OracleConnectionFactory;

/**
 * Hello world!
 */
public class App {

	public static void main(String[] args) throws SQLException, InterruptedException {
		System.out.println("start");

		Properties properties = new Properties();
		properties.setProperty(OracleConnectionFactory.KEY_ORCALE_CONNECTION_URL, "jdbc:oracle:thin:@localhost:1521:orcl");
		properties.setProperty(OracleConnectionFactory.KEY_ORCALE_CONNECTION_USER, "jdbctest");
		properties.setProperty(OracleConnectionFactory.KEY_ORCALE_CONNECTION_PASSWORD, "password");

		ConnectionFactory factory = new OracleConnectionFactory(properties);

		int initialConnectionSize = 100;
		Connection[] connectionArr = new Connection[initialConnectionSize];
		for (int i = 0; i < initialConnectionSize; i++) {
			Connection connection = factory.create();
			System.out.println("create a connection:" + i);
			connectionArr[i] = connection;
		}

		Thread.sleep(30 * 1000); // sleep 30s

		for (int i = 0; i < initialConnectionSize; i++) {
			try {
				System.out.println("close a connection:" + i);
				connectionArr[i].close();
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}

		System.out.println("over");
	}

}
