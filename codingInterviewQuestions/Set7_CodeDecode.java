package codingInterviewQuestions;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Set7_CodeDecode {
	static List<Employee> employeeList = new ArrayList<>();
	

	public static void main(String[] args) {
		employeeList.add(new Employee(1,"Yogesh",31));
		employeeList.add(new Employee(2,null,31));

		DefaultValueWithOrElse();
		DefaultValueWithOrElseGet();
		ExceptionWithOrElseThrow();
	}


	private static void DefaultValueWithOrElse() {
		Employee emp0 = employeeList.get(0);
		Employee emp = employeeList.get(1);
		Optional<String> optionalName = Optional.ofNullable(emp.getName());
		if (optionalName.isPresent()) {
			System.out.println(optionalName.get());
		}
		// OrElse method is used to retrieve the value wrapped inside the
		// Optional instance
		// It takes one parameter , which acts as Optional value
		// The OrElse() method returns the wrapped value if its present ,and its
		// arguments otherwise.

		// Optional.ofNullable : returns an Optional with a present value if the
		// specified value is non-null,
		// otherwise an empty Optional
		// But if we add OrElse then it will automatically convert optional to
		// String value
		String name = Optional.ofNullable(emp.getName()).orElse("Anonymous");
		System.out.println("orElse with Hardcoded String value " + name);
		
		//Even if getName() method returns a valid value still callMe() method call is executed
		//GC will the sweep out the unwanted string created in callMe() method.
		String namecallMe = Optional.ofNullable(emp0.getName()).orElse(callMe());
		System.out.println("OrElse with callMe Method " + namecallMe);
		

	}

	private static void DefaultValueWithOrElseGet() {
		//orElseGet takes Supplier Functional Interface as Input.
		
		Employee emp = employeeList.get(1);
		Employee emp0 = employeeList.get(0);

		String name = Optional.ofNullable(emp.getName()).orElseGet(() -> "Anonymous");
		System.out.println("OrElseGet with Hardcoded String value " + name);
		
		// getName() method returns a valid value , So callMe() method call is Not executed.
		// This is another difference between OrElse & OrElseGet
		//So use OrElseGet . do not use OrElse as it has performance impact
		String nameWithCallMe = Optional.ofNullable(emp0.getName()).orElseGet(() -> callMe());

		System.out.println("OrElseGet with callMe Method " + nameWithCallMe);

	}
	private static String callMe(){
		System.out.println("I am called");
		return "anonymous";
	}
	

	private static void ExceptionWithOrElseThrow() {
		Employee emp = employeeList.get(1);

		String name = Optional.ofNullable(emp.getName()).orElseThrow(() -> new IllegalArgumentException("No Name Present for the Employee Object "));
		
	}
}
