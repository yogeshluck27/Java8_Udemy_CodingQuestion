package codingInterviewQuestions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

class Employee {
	int id;
	String name;
	int age;

	
	public Employee(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}

public class Set2_CodeDecode {

	static List<Employee> employeeList = new ArrayList<>();

	public static void main(String[] args) {
		groupEmployeesByAge();
		groupEmployeesByAgeAndUniqueEmployee();
		groupEmployeesByAgeAndUniqueEmployeeAndSorted();
	}

	// Grouping Collector use a classification function,which is an instance of
	// a Function<T,K>
	// T -> type of object in stream
	// K -> these are the 'group name' or 'group keys'.
	// For every value of K there is collection of objects all of which return
	// that value of K
	// when subjected to classification function
	// All these K - values & corresponding collection of stream objects are
	// stored by grouping collector in
	// Map <K,Collection<T>>

	// 1st variant of groupingBy -> 1st arg as Classifier Function & returns Collectors.toList by default
	private static void groupEmployeesByAge() {

		Map<Integer, List<Employee>> empMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getAge));

		// Key is Age

	}
	// We want to group the employees by Age & then collect into Set to get
	// Unique Employees
	// We have Overridden Equals method for employee name
	// Two employee with same name will be considered as Same object

	// 2nd Variant of GroupingBy which take downstream (collectors) as the
	// second argument & 1st arg as Classifier Function
	// Here we have used toSet() as second arg -> how the grouped elements to be
	// collected
	private static void groupEmployeesByAgeAndUniqueEmployee() {
		Map<Integer, Set<Employee>> empMap = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getAge, Collectors.toSet()));
	}

	// 3rd Variant of GroupingBy which take 1st arg as Classifier Function ,
	//2nd argument as Supplier , 3rd argument as DownStream Collector
	// Here we have use TreeMap so all the employees will be in Sorted Order
	private static void groupEmployeesByAgeAndUniqueEmployeeAndSorted() {
		Map<Integer, Set<Employee>> empMap = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getAge, TreeMap::new, Collectors.toSet()));
	}
	
	//Internally single parameter groupingBy calls two parameter
	//groupingBy(classifier,toList())
	
	//Intenally 2 paramter grouping by calls three paramaters
	//groupingBy(classifier, HashMap::new,toList())

	//Convert Emplyee List to List of names then convert it to upperCase
	//And we want to join all the sames using , separator
	private static void employeeNamesJoining(){
		String empNames = employeeList.stream().map(emp -> emp.getName().toUpperCase()).collect(Collectors.joining(",  "));
	}

}
