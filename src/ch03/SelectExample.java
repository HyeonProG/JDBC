package ch03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectExample {
	
	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/mydb2?serverTimezone=Asia/Seoul";
		String user = "root";
		String password = "asd123";
		
		// Connection 객체를 얻어서 select 구문을 직접 만들어 보세요.
		// datebase - mydb2 사용, table - employee 테이블에 값을 넣는 코드를 작성하세요.
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);
			
			String query = "select * from employee";
			preparedStatement = connection.prepareStatement(query);			
			resultSet = preparedStatement.executeQuery();
			
//			List<Employee> list = new ArrayList<>();
			
			while(resultSet.next()) {
//				int id = resultSet.getInt("id");
//				String name = resultSet.getString("name");
//				String department = resultSet.getString("department");
//				String salary = resultSet.getString("salary");
//				String hire_date = resultSet.getString("hire_date");
//				
//				Employee employee = new Employee();
//				employee.setId(id);
//				employee.setName(name);
//				employee.setDepartment(department);
//				employee.setSalary(salary);
//				employee.setHire_date(hire_date);
//				
//				list.add(employee);

//				Employee employee = new Employee(resultSet.getInt("id"), resultSet.getString("name")
//						, resultSet.getString("department"), resultSet.getString("salary"), resultSet.getString("hire_date"));

				Employee employee = new Employee(resultSet.getInt(1), resultSet.getString(2)
						, resultSet.getString(3), resultSet.getString(4), resultSet.getString(5));
				
				System.out.println(employee);
				
				
			}
			
//			for (Employee employee : list) {
//				System.out.println(employee.getId());
//				System.out.println(employee.getName());
//				System.out.println(employee.getDepartment());
//				System.out.println(employee.getSalary());
//				System.out.println(employee.getHire_date());
//			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	} // end of main

} // end of class
