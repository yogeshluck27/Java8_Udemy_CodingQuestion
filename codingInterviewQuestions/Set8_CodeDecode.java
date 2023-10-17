package codingInterviewQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Emp {
	private int id;
	private long salary;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public Emp(int id, long salary) {
		super();
		this.id = id;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", salary=" + salary + "]";
	}

}

public class Set8_CodeDecode {

	public static void main(String[] args) {
		List<Emp> empList = new ArrayList<>();
		empList.add(new Emp(1, 500));
		empList.add(new Emp(2, 1000));
		empList.add(new Emp(3, 1500));
		empList.add(new Emp(4, 2000));
		empList.add(new Emp(5, 2500));
		empList.add(new Emp(6, 3000));
		empList.add(new Emp(7, 3500));

		sortEmployeeWithSalary(empList);
		Top3SalariedEmployees(empList);
		ThirdHighestSalaryOfEmployee(empList);
		SalaryLessThanThirdHighestSalaryOfEmployee(empList);
	}


	


	private static void sortEmployeeWithSalary(List<Emp> empList) {

		List<Emp> empSortedList = empList.stream().sorted((e1, e2) -> (int) (e2.getSalary() - e1.getSalary()))
				.collect(Collectors.toList());
		System.out.println("empSortedList in descending order of salary " + empSortedList);
		
		List<Emp> empSortedList1 = empList.stream().sorted(Collections.reverseOrder((e1, e2) -> (int) (e1.getSalary() - e2.getSalary()))).collect(Collectors.toList());
		System.out.println("empSortedList1 in descending order of salary " + empSortedList1);


	}

	private static void Top3SalariedEmployees(List<Emp> empList) {
		List<Emp> empSortedList = empList.stream().sorted((e1, e2) -> (int) (e2.getSalary() - e1.getSalary())).limit(3)
				.collect(Collectors.toList());
		System.out.println("Top 3 salaried Employees " + empSortedList);
	}
	

	private static void ThirdHighestSalaryOfEmployee(List<Emp> empList) {
		Emp emp = empList.stream().sorted((e1, e2) -> (int) (e2.getSalary() - e1.getSalary()))
					.skip(2)
					.findFirst().get();
		System.out.println("Employee with 3rd Highest Salary " + emp);
	}
	
	private static void SalaryLessThanThirdHighestSalaryOfEmployee(List<Emp> empList) {
		List<Emp> empSortedList= empList.stream().sorted((e1, e2) -> (int) (e2.getSalary() - e1.getSalary()))
				.skip(3)
				.collect(Collectors.toList());
	System.out.println("Employees with salary less than with 3rd Highest Salaried Employee " + empSortedList);		
	}

}
