package ch04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TransactionExample2 {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/m_board?serverTimezone=Asia/Seoul";
		String id = "root";
		String password = "asd123";

		try {
			// mysql 드라이버를 메모리에 로드
			Class.forName("com.mysql.cj.jdbc.Driver");
			// try - catch - resource
			try (Connection conn = DriverManager.getConnection(url, id, password)) {
				conn.setAutoCommit(false);
				String sqlDelete = " DELETE from user where userName = ? ";
				PreparedStatement psmt1 = conn.prepareStatement(sqlDelete);
				psmt1.setString(1, "김철수");
				psmt1.executeUpdate();

				conn.commit();

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	} // end of main

} // end of class
