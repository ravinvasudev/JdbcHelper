package rv.jdbchelper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

/**
 * @author Ravin Vasudev
 * @version 1.0
 * @since Sep 2016
 * @category JDBCHelper
 * 
 *           <p>
 *           Database connection wrapper class for managing connection life
 *           cycle.
 *           </p>
 *
 */
public class JdbcConnection {

	private String host;
	private String port;
	private String service;
	private String user;
	private String password;
	private DataSource dataSource;
	private Properties properties;

	/**
	 * @param host
	 * @param port
	 * @param service
	 * @param user
	 * @param password
	 */
	public JdbcConnection(String host, String port, String service, String user, String password) {
		this.host = host;
		this.port = port;
		this.service = service;
		this.user = user;
		this.password = password;
	}

	// will work on this later
	/**
	 * Initialize the connection using Properties
	 * 
	 * @param properties
	 */
	public JdbcConnection(Properties properties) {
		this.properties = properties;
	}

	/**
	 * Initialize the connection using DataSource
	 * 
	 * @param dataSource
	 */
	public JdbcConnection(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * Method to open a database connection.
	 * 
	 * @return
	 * @throws SQLException
	 */
	protected Connection get() throws SQLException {
		return this.dataSource.getConnection();
	}

	/**
	 * Closes opened connection to database. Release resources.
	 * 
	 * @param conn
	 */
	public void close(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
