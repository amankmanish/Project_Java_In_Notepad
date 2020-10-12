import java.sql.*;

class Dao
{
	public static Connection createConnection()
	{
		Connection con=null;

		try
		{
			//Class.forName("com.mysql.jdbc.Driver");
			//con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
		}
		catch(Exception e)
		{
		}
		return con;
	}
}