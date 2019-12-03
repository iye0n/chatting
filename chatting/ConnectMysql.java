package chatting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectMysql {
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String password = "skdus0824";
			String url = "jdbc:mysql:192.168.43.74";
			String user = "root";
			connection = DriverManager.getConnection(url, user, password);
			statement = connection.createStatement();
			
			String sql = "select from table";
			
			ResultSet resultSet = statement.executeQuery(sql);
			//String columnLabel = "";
			
			while(resultSet.next()) {
				//String sqlProcess = resultSet.getString(columnLabel);
			}
			resultSet.close();
			statement.close();
			connection.close();
		}
		catch(SQLException e1) {
			e1.printStackTrace();
		}
		catch(Exception e2) {
			e2.printStackTrace();
		}
		finally {
			try {
				if(statement != null) {
					statement.close();
				}
			}catch(SQLException e3) {
				e3.printStackTrace();
			}
			try {
				if(connection != null) {
					connection.close();
				}
			}catch(SQLException e4) {
				e4.printStackTrace();
			}
		}
	}
}