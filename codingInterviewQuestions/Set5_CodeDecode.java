package codingInterviewQuestions;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

//Fetch Max Age of Emp
//Min aged Employee
//Avg age of emp
//Sum & Count of employees etc
public class Set5_CodeDecode {
	static List<Employee> employeeList = new ArrayList<>();

	public static void main(String[] args) {
		employeeList.add(new Employee(1,"Yogesh",31));
		employeeList.add(new Employee(2,"Indrayani",25));
		employeeList.add(new Employee(3,"Akshay",20));
		employeeList.add(new Employee(4,"Yatin",44));
		employeeList.add(new Employee(5,"Neha",54));
		employeeList.add(new Employee(6,"Vicky",100));
		employeeList.add(new Employee(7,"Mayur",77));

		
		List<Integer> ages = employeeList.stream().map(emp -> emp.getAge()).collect(Collectors.toList());
		//Before using summaryStatistics , We have to convert every element to an Integer
		//Hence we have used mapToInt() which returns int stream.
		IntSummaryStatistics summary = ages.stream().mapToInt(x->x).summaryStatistics();
		
		//IntSummaryStatistics provides below methods
		System.out.println(summary.getAverage());
		System.out.println(summary.getMax());
		System.out.println(summary.getMin());
		System.out.println(summary.getSum());
		System.out.println(summary.getCount());
		

		findSecondAndThirdYongestEmployee(employeeList);
		getConactenatedNamesOfAllEmployees(employeeList);

	}
	
	private static void getConactenatedNamesOfAllEmployees(List<Employee> employeeList2) {
		//Collectors.joining(delimiter , prefix , sufffix) is used to join list of string and return single string as output
		String empNames = employeeList.stream().map(emp -> emp.getName().toUpperCase())
								.collect(Collectors.joining(",  ","[","]"));		
		System.out.println("Employee Names concatenated with delimiter , are "+empNames);
	}

	private static void findSecondAndThirdYongestEmployee(List<Employee> employeeList) {
		//Sort employees as per age then skip 1st and get next 2 in the order
		List<Integer> empAges = employeeList.stream().map(emp -> emp.getAge()).sorted().skip(1).limit(2)
										.collect(Collectors.toList());
		System.out.println("Second and third youngest employees ages are  " + empAges);

	}
	
}
