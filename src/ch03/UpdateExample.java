package ch03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateExample {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/mydb2?serverTimezone=Asia/Seoul";
		String user = "root";
		String password = "asd123";

		// Connection 객체를 얻어서 수정 구문을 직접 만들어 보세요.
		// datebase - mydb2 사용, table - employee 테이블에 값을 넣는 코드를 작성하세요.
		Connection connection = null;
		ResultSet resultSet = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);
			String query = "update employee set department =? where id =?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, "개발");
			preparedStatement.setInt(2, 8);
			
			int rowCount = preparedStatement.executeUpdate();
			
			System.out.println("rowCount : " + rowCount);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	
	} // end of main

} // end of class
