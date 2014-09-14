/**
 * Created By: Comwave Project Team
 * Created Date: 2014年9月11日
 */
package com.sisopipo.jdbc.connection.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.sisopipo.jdbc.connection.ConnectionFactory;

/**
 * @author Geln Yang
 * @version 1.0
 */
public class OracleConnectionFactory implements ConnectionFactory {

	private static final String ORACLE_DRIVER_CLASS = "oracle.jdbc.driver.OracleDriver";

	public static final String KEY_ORCALE_CONNECTION_URL = "oracle.connection.url";

	public static final String KEY_ORCALE_CONNECTION_USER = "oracle.connection.user";

	public static final String KEY_ORCALE_CONNECTION_PASSWORD = "oracle.connection.password";

	private Properties configurationProperties = System.getProperties();

	public void init() {
		try {
			Class.forName(ORACLE_DRIVER_CLASS).newInstance();
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public OracleConnectionFactory() {
		init();
	}

	public OracleConnectionFactory(Properties properties) {
		this();
		this.configurationProperties = properties;
	}

	private String getConnectionURL() {
		return configurationProperties.getProperty(KEY_ORCALE_CONNECTION_URL);
	}

	private String getConnectionUser() {
		return configurationProperties.getProperty(KEY_ORCALE_CONNECTION_USER);
	}

	private String getConnectionPassword() {
		return configurationProperties.getProperty(KEY_ORCALE_CONNECTION_PASSWORD);
	}

	public Connection create() throws SQLException {
		return DriverManager.getConnection(getConnectionURL(), getConnectionUser(), getConnectionPassword());
	}

}
