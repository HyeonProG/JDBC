package ch01.dto;

// DTO를 설계하고
// 값을 담아서 . 연산자를 사용해 보세요.
public class Employee {

	private int id;
	private String name;
	private String department;

	public Employee() {
	}

	public Employee(int id, String name, String department) {
		this.id = id;
		this.name = name;
		this.department = department;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", department=" + department + "]";
	}

}
