package ch03;

// DTO를 설계하고
// 값을 담아서 . 연산자를 사용해 보세요.
public class Employee {

	private int id;
	private String name;
	private String department;
	private String salary;
	private String hire_date;

	public Employee() {
	}

	public Employee(int id, String name, String department, String salary, String hire_date) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.salary = salary;
		this.hire_date = hire_date;
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

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getHire_date() {
		return hire_date;
	}

	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", department=" + department + ", salary=" + salary
				+ ", hire_date=" + hire_date + "]";
	}



}
