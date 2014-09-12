/**
 * Created By: Comwave Project Team
 * Created Date: 2014年9月11日
 */
package com.sisopipo.jdbc.connection;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Geln Yang
 * @version 1.0
 */
public interface ConnectionFactory {

	public Connection create() throws SQLException;
}
