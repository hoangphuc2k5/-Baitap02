package vidu2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {
	private final String serverName = "LAPTOP-URG53QT4\\SQLEXPRESS";
	private final String dbName = "ltweb";
	private final String portNumber = "1433";
	private final String instance = "";
	private final String userID = "sa";
	private final String password = "123";
	public Connection getConnection() throws Exception {
		String url =
		"jdbc:sqlserver://" + serverName + "\\" + instance+
		";encrypt=true;trustServerCertificate=true;databaseName=" + dbName;
		if (instance == null || instance.trim().isEmpty())
		url =
		"jdbc:sqlserver://"+serverName
		+";encrypt=true;trustServerCertificate=true;databaseName="+dbName;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		return DriverManager.getConnection(url, userID, password);
		}
	public static void main(String[] args) {
		try {
		System.out.println(new DBConnection().getConnection());
		} catch (Exception e) {
		e.printStackTrace();
		}
		}
}