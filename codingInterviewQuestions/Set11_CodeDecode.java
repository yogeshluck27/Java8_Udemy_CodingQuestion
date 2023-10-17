package codingInterviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@FunctionalInterface
interface Finterface {
	public int multiply(int a, int b);
}

public class Set11_CodeDecode {

	public static void main(String[] args) {
		Finterface total = (a, b) -> a * b;
		System.out.println(total.multiply(6, 7));
		System.out.println("-----------------------------------------");
		findDuplicateElementsinIntegerList();
		System.out.println("-----------------------------------------");
		countNoOfOccurenacesOfWordinString();

	}

	private static void countNoOfOccurenacesOfWordinString() {

		String input = "welcome to Code Decode and Code Decode welcome you";
		List<String> list = Arrays.asList(input.split(" "));
		list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.forEach(s -> System.out.println(s.getKey() + " " + s.getValue()));
		

	}

	private static void findDuplicateElementsinIntegerList() {
		List<Integer> list = Arrays.asList(10, 28, 87, 10, 76, 28, 26, 80, 80);

		/*
		 * Set<Integer> duplicateElements = list.stream().filter(e->
		 * Collections.frequency(list, e) > 1).collect(Collectors.toSet());
		 * duplicateElements.forEach(System.out :: println);
		 */

		Set<Integer> duplicates = new HashSet<Integer>();
		list.stream().filter(e -> !duplicates.add(e)).forEach(x -> System.out.println(x));
	}

}
