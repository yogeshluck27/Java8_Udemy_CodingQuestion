package codingInterviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Emp1 {
	private int id;
	private String name;

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

	public Emp1(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Emp1 [id=" + id + ", name=" + name + "]";
	}

	public void printName() {
		System.out.println("In the Emp class " + name);
	}
}

public class Set10_CodeDecode_TerminalVsNonTerminal {

	public static void main(String[] args) {
		List<Emp1> empList = new ArrayList<>();
		empList.add(new Emp1(1, "code1"));
		empList.add(new Emp1(2, "code22"));
		empList.add(new Emp1(3, "code333"));
		empList.add(new Emp1(4, "code4"));

		
		empList.stream().filter(e -> e.getId()%2 == 0).map(e-> {
			e.printName();
			return e.getName();
		}).forEach(e -> System.out.println("At Last "+e)); //forEach is termincal operation

		empList.stream().filter(e -> e.getId()%2 == 0).map(e-> {
			e.printName();
			return e.getName();
		}); 
		//filter , map are intermediate operations which are called only when there is termincal op
		//Hence intermediate operation are called as lazy loaded
		//Intermediate operation returns a Stream whereas Terminal operation returns non Stream values
		//Intermediate operation can be chained .Terminal operations can not be chained together
		
		System.out.println("-------------------Debugging using peek()-------------------");
		List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
/*		System.out.println(intList.stream().filter(a -> a%2 == 0)
				.peek(e->System.out.println(e)).map(a -> a+a).filter(a -> a>5).count());*/
		
		System.out.println(intList.stream().filter(a -> a%2 == 0)
				.map(a -> a+a).peek(e->System.out.println(e)).filter(a -> a>5).count());
		
		//peek() method takes consumer object. performs some action returns nothing
		//mainly used for debugging
		
		System.out.println("-------------------reduce()-------------------");
		//reduce() is used to combine a stream and produces single value
		//reduce() operation applies a binary operator to each element in stream
		//where the first argument of operator is the return value of previous application
		//second argument is current stream element.
		System.out.println("Sum of elements using reduce "+intList.stream().reduce((a,b)-> a+b).get());

	}

}
