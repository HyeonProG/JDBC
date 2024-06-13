package ch05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchExample {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/demo3?serverTimezone=Asia/Seoul";
		String user = "root";
		String password = "asd123";
		Connection conn = null;

		try {
			// MySQL 드라이버 로드
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 자바 표준 API
			conn = DriverManager.getConnection(url, user, password);

			// 트랜잭션 처리
			conn.setAutoCommit(false); // 수동 커밋으로 변경

			// 배치 처리 --> User 라는 가상의 테이블에 한번에 사용자 3명을 넣어보자.
			String sql = " INSERT INTO users(name, email) VALUES(?, ?) ";
			PreparedStatement psmt = conn.prepareStatement(sql);

			// 1번 사용자 처리
			psmt.setString(1, "유저1");
			psmt.setString(2, "유저1@nate.com");
			// psmt.executeUpdate();
			// 배치 처리하기 위해 호출할 메서드가 필요
			psmt.addBatch(); // <--

			// 2번 사용자 처리
			psmt.setString(1, "유저2");
			psmt.setString(2, "유저2@nate.com");
			psmt.addBatch();

			// 3번 사용자 처리
			psmt.setString(1, "유저3");
			psmt.setString(2, "유저3@nate.com");
			psmt.addBatch();

			int[] rowCounts = psmt.executeBatch();

			conn.commit(); // 물리적인 저장 장치에 영구히 반영
			System.out.println("배치 처리 완료 : " + rowCounts.length);

		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	} // end of main

} // end of class
