package ch04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TransactionExample {

	public static void main(String[] args) {

		// 드라이버 -> MySQL 개발자들이 자바 코드로 작성한 클래스의 묶음(.jar)
		// ver 8.0 이상 검색 활용
		String url = "jdbc:mysql://localhost:3306/m_board?serverTimezone=Asia/Seoul";
		String id = "root";
		String password = "asd123";

		// 구현체를 사용하기 위해서
		// 클래스 Class <-- 최상위 Object 안에 있다.
		// 동적 바인딩 처리
		try {
			// mysql 드라이버(구현 클래스) 메모리에 로드
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Connection conn = null;
			// try catch resource 문법
			try (Connection conn = DriverManager.getConnection(url, id, password)) {
				conn.setAutoCommit(false); // 수동 커밋 모드 설정
				String sqlInsert = " INSERT INTO user(userName, password, email, userRole, address, createDate) "
						+ " values(?, ?, ?, ?, ?, now()) ";
				PreparedStatement psmt1 = conn.prepareStatement(sqlInsert);
				psmt1.setString(1, "김철수");
				psmt1.setString(2, "asd123");
				psmt1.setString(3, "a@nate.com");
				psmt1.setString(4, "user");
				psmt1.setString(5, "부산시 진구");
				psmt1.executeUpdate();

				String sqlUpdate = "UPDATE user SET email = ? WHERE userName = ?";
				PreparedStatement psmt2 = conn.prepareStatement(sqlUpdate);
				psmt2.setString(1, "b@naver.com");
				psmt2.setString(2, "김유신");
				psmt2.executeUpdate();
				
				// 수동 커밋 모드를 설정했다면, 직접 커밋을 실행해야
				// 물리적인 저장 장치에 영구히 반영이 된다.
				conn.commit();

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	} // end of main

} // end of class
