package rv.jdbchelper;

/**
 * @author Ravin Vasudev
 * @version 1.0
 * @since Sep 2016
 * @category JDBCHelper
 * 
 *           <p>
 *           Represents a column in a row
 *           </p>
 *
 */
public class JdbcColumn {

	private String name;
	private String value;
	private String type;

	/**
	 * Name of a column
	 * 
	 * @return
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Value of a column
	 * 
	 * @return
	 */
	public String getValue() {
		return this.value;
	}

	/**
	 * Name of a column
	 * 
	 * @return
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Value of a column
	 * 
	 * @return
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * Data type of column value
	 * 
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * Data type of column value
	 * 
	 * @return
	 */
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return String.format("JdbcColumn [name=%s, value=%s, type=%s]", name, value, type);
	}

}
