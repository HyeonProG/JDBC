package ch03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteExample {
	
	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/mydb2?serverTimezone=Asia/Seoul";
		String user = "root";
		String password = "asd123";
		
		// Connection 객체를 얻어서 삭제 구문을 직접 만들어 보세요.
		// datebase - mydb2 사용, table - employee 테이블에 값을 넣는 코드를 작성하세요.
		Connection connection = null;
		ResultSet resultSet = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);
			String query = "delete from employee where name =?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, "강감찬");
			
			int rowCount = preparedStatement.executeUpdate();
			System.out.println("rowCount : " + rowCount);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
	} // end of main

} // end of class
