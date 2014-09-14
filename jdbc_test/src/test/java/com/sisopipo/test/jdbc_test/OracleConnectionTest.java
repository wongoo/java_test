/**
 * Created By: gelnyang at 163.com
 * Created Date: 2014年9月14日
 */
package com.sisopipo.test.jdbc_test;

import java.sql.Connection;
import java.util.Properties;

import org.junit.Test;

import com.sisopipo.jdbc.connection.ConnectionFactory;
import com.sisopipo.jdbc.connection.factory.OracleConnectionFactory;

/**
 * @author Geln Yang
 * @version 1.0
 */
public class OracleConnectionTest {

	@Test
	public void testCreateConnections() {
		try {
			System.out.println("start");

			Properties properties = new Properties();
			properties.setProperty(OracleConnectionFactory.KEY_ORCALE_CONNECTION_URL, "jdbc:oracle:thin:@bpmdb:1521:orcl");
			properties.setProperty(OracleConnectionFactory.KEY_ORCALE_CONNECTION_USER, "jdbctest");
			properties.setProperty(OracleConnectionFactory.KEY_ORCALE_CONNECTION_PASSWORD, "password");

			ConnectionFactory factory = new OracleConnectionFactory(properties);

			int initialConnectionSize = 500;
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
		} catch (Throwable e) {
			e.printStackTrace(); //IF the connection is over the maxinum , then it will throw a exception "Got minus one from a read call"
		}
	}
}
