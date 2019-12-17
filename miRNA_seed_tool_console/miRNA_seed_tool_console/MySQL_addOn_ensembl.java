package miRNA_seed_tool_console;
import java.sql.*;

public class MySQL_addOn_ensembl {
static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	
	private static final String url = "jdbc:mysql://ensembldb.ensembl.org:3306";
	
	private static final String user = "anonymous";
	
	private static final String password = "";
	
	public static void main(String args[]) {
		
		Statement stmt = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			// Creating Connection to local mysql server using local information
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection established");
			
			// Creating first statements
			stmt = con.createStatement();
			String sql;
			sql = "SHOW DATABASES";
			ResultSet rs = stmt.executeQuery(sql);
			
		}catch (Exception e) {
			
			System.out.println("NOPE");
			e.printStackTrace();
			
		}
	}
}
