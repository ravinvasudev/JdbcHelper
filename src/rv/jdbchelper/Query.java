package rv.jdbchelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ravin Vasudev
 * @version 1.0
 * @since Sep 2016
 * @category JDBCHelper
 * 
 *           <p>
 *           Class to handle SQL queries, execution and prepare tabular
 *           response.
 *           </p>
 *
 */
public class Query {

	private JdbcConnection jdbcConnection;

	/**
	 * Initialize with JDBCConnection object
	 * 
	 * @param jdbcConnection
	 */
	public Query(JdbcConnection jdbcConnection) {
		this.jdbcConnection = jdbcConnection;
	}

	/**
	 * Executes the query on underneath database connection.
	 * 
	 * @param sqlQuery
	 * @return
	 */
	public JdbcTable execute(String sqlQuery) {
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = jdbcConnection.get();
			stat = conn.createStatement();
			rs = stat.executeQuery(sqlQuery);
			return processResult(rs);
		} catch (SQLException e) {
			System.err.println("Error Code: " + e.getErrorCode());
			System.err.println("Error Message: " + e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
		} finally {
			if (rs != null) {
				try {
					if (!rs.isClosed()) {
						rs.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stat != null) {
				try {
					if (!stat.isClosed()) {
						stat.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			jdbcConnection.close(conn);
		}
		return null;
	}

	private JdbcTable processResult(ResultSet rs) throws SQLException {

		ResultSetMetaData meta = rs.getMetaData();
		int columnCount = meta.getColumnCount();

		/* Construct Table Column Names from MetaData. */
		List<String> columnNames = new ArrayList<String>();
		Map<String, Integer> columnType = new HashMap<String, Integer>();

		for (int i = 1; i <= columnCount; i++) {

			String colName = meta.getColumnName(i);
			Integer colType = meta.getColumnType(i);

			columnNames.add(colName);
			columnType.put(colName, colType);
		}

		if (rs != null && rs.isBeforeFirst()) {
			final JdbcTable jdbcTable = new JdbcTable();

			while (rs.next()) {
				final List<JdbcColumn> columns = new ArrayList<JdbcColumn>();
				for (String columnName : columnNames) {

					JdbcColumn column = new JdbcColumn();
					column.setName(columnName);
					column.setValue(rs.getString(columnName));
					columns.add(column);
				}

				final JdbcRow row = new JdbcRow();
				row.getColumns().addAll(columns);
				jdbcTable.getRows().add(row);
			}
			return jdbcTable;
		}
		return null;
	}

}

/*
 * http://docs.oracle.com/javase/7/docs/api/constant-values.html#java.sql.Types.
 * INTEGER
 */