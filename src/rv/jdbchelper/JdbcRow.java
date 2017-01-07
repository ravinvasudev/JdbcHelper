package rv.jdbchelper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ravin Vasudev
 * @version 1.0
 * @since Sep 2016
 * @category JDBCHelper
 * 
 *           <p>
 *           Represents the row in database.
 *           </p>
 *
 */
public class JdbcRow {

	private List<JdbcColumn> columns;

	public JdbcRow() {
		this.columns = new ArrayList<JdbcColumn>();
	}

	public List<JdbcColumn> getColumns() {
		return this.columns;
	}

	@Override
	public String toString() {
		return String.format("JdbcTableRow [columns=%s]", columns);
	}

}
