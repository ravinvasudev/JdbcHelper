package rv.jdbchelper;

public class QueryBuilder {

	private Query jdbcQuery;

	public QueryBuilder(JdbcConnection conn) {
		
		this.jdbcQuery = new Query(conn);
	}

	public JdbcTable buildTable(String sqlQuery) {

		return jdbcQuery.execute(sqlQuery);

	}

}
