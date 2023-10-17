package codingInterviewQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Set6_CodeDecode {

	static List<Employee> employeeList = new ArrayList<>();

	public static void main(String[] args) {
		findDuplicateNamesUsingSet();
		findDuplicateNamesUsingGroupingBy();
	}

	// Find Duplicate name
	private static Set findDuplicateNamesUsingSet() {

		Set<String> uniqueNames = new HashSet<>();
		List<String> empNames = employeeList.stream().map(emp -> emp.name).collect(Collectors.toList());

		Set<String> duplicateNames = empNames.stream().filter(name -> !uniqueNames.add(name))
				.collect(Collectors.toSet());
		// add method will return true if element is added means not present in
		// set already.

		return duplicateNames;
	}

	// Find Duplicate name
	private static Set findDuplicateNamesUsingGroupingBy() {
		// empNames is list of all names of employee
		List<String> empNames = employeeList.stream().map(emp -> emp.name).collect(Collectors.toList());
		// empMap is map of Employee Name as Key and value is its frequency
		// identity is function which returns the input
		Map<String, Long> empMap = empNames.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		// empSet will return Emp name whose count is greater than 1.so its
		// duplicate
		// On map we cannot use Stream directly bcoz its not collection.
		//We can use EntrySet collection to apply stream  .Entry set is set of key value pairs
		
		Set<String> empSet = empMap.entrySet().stream().filter(e -> e.getValue() > 1).map(e -> e.getKey())
				.collect(Collectors.toSet());
		return empSet;
	}

	// Find Duplicate name
	private static Set findDuplicateNamesUsingFrequncy() {
		// empNames is list of all names of employee
		List<String> empNames = employeeList.stream().map(emp -> emp.name).collect(Collectors.toList());
		Set<String> empSet = empNames.stream().filter(name -> Collections.frequency(empNames, name) > 1)
				.collect(Collectors.toSet());
		return empSet;

		// Collections.frequency(c,o) => Returns the number of elements in the
		// specified collection
		// equal to the specified object
	}

}
