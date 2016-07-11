package ordermap.persistence;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BaseDAO {
	private static final String DB_DRIV = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/orderapp";
	private static final String DB_USER = "root";
	private static final String DB_PASS = "Super00t";
//	
	protected final Connection getConnection(){
		Connection result = null;
		
		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/MySQLDS");
			
			result = ds.getConnection();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		
		return result;
	}
	
	
	
	
}
