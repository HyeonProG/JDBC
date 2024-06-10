package ch01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ch01.dto.Employee;

public class MySQLJdbcExample {

	public static void main(String[] args) {

		// 준비물
		String url = "jdbc:mysql://localhost:3306/mydb2?serverTimezone=Asia/Seoul";
		String user = "root"; // 상용서비스에서 절대 루트 계정 사용 금지
		String password = "asd123";

		// 필요 데이터 타입
		// JDBC API 레벨(자바 개발자들이 개념화 시켜 놓은 클래스들)
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		// 1. MySQL 구현체를 사용하겠다는 설정을 해야한다.
		// JDBC 드라이버 로드 (MySQL 드라이버)
		try {
			// 1. 메모리에 사용하는 드라이버(JDBC API 를 구현한 클래스) 클래스를 띄운다.
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. 데이터베이스에 연결 설정
			connection = DriverManager.getConnection(url, user, password);

			// 3. SQL 실행
			statement = connection.createStatement();

			// 딱 2 가지는 기억하자. 쿼리를 실행 시키는 메서드
			resultSet = statement.executeQuery("SELECT * FROM employee"); // --> Select 실행시 사용
			// statement.executeUpdate(""); --> Insert, Update, Delete 사용

			// 구문 분석 -- 파싱
			// 4. 결과 처리
			List<Employee> list = new ArrayList<>();

			while (resultSet.next()) {
//				System.out.println("USER ID : " + resultSet.getInt("id"));
//				System.out.println("USER NAME : " + resultSet.getString("name"));
//				System.out.println("DEPARTMENT : " + resultSet.getString("department"));
//				System.out.println("----------------------------------------");

				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String department = resultSet.getString("department");

				Employee employee = new Employee();
				employee.setId(id);
				employee.setName(name);
				employee.setDepartment(department);

				list.add(employee);

			}

			for (Employee employee : list) {
				System.out.println(employee.getId());
				System.out.println(employee.getName());
				System.out.println(employee.getDepartment());
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	} // end of main

} // end of class
