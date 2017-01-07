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
 *           This class represents the query response.
 *           </p>
 *
 */
public class JdbcTable {

	private List<JdbcRow> jdbcTableRows;

	public JdbcTable() {
		this.jdbcTableRows = new ArrayList<JdbcRow>();
	}

	public List<JdbcRow> getRows() {
		return this.jdbcTableRows;
	}

	@Override
	public String toString() {
		return String.format("JdbcTable [jdbcTableRows=%s]", jdbcTableRows);
	}

}
