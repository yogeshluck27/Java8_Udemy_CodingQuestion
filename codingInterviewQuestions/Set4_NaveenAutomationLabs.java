package codingInterviewQuestions;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Set4_NaveenAutomationLabs {

	public static void main(String[] args) {

		// printSumOfAllNumbers();
		// printAverageOfAllNumbers();
		// NumberSquareAverage();
		// PrintEvenAndOddNumbers();
		// PrintNumbersStartsWithPrefix2();
		// FindDuplicateNumbers();
		//findMinMax();
		//doSorting();
		//GetFirstFiveNumbersFromList();
		SecondHighestAndLowestNumber();

	}

	private static void SecondHighestAndLowestNumber() {
		 List<Integer> list = Arrays.asList(3,3,5,7,5,7,9,10,12,12,14,14,0);
		 
		 int secondHigh = list.stream().sorted(Collections.reverseOrder()).distinct()
				 		 	.skip(1).findFirst().get();
		 
		 System.out.println("Second Highest number is "+secondHigh);
		 
		 int secondLow = list.stream().sorted().distinct()
		 		 		 .skip(1).findFirst().get();
 
		 System.out.println("Second Highest number is "+secondLow);
 
	}

	private static void GetFirstFiveNumbersFromList() {
		 List<Integer> list = Arrays.asList(3,3,5,7,5,7,9,10,12,12,14,14,0);
		 //Limit 
		 List<Integer> firstFiveNumbers =  list.stream().limit(5).collect(Collectors.toList());
		 System.out.println("firstFiveNumbers are " + firstFiveNumbers);
		 
		 //Get Sum of First five numbers in ArrayList
		 Integer firstFiveNumbersSum =  list.stream().limit(5).reduce((a,b) -> a+b).get();
		 System.out.println("Sum of First Five numbers is "+firstFiveNumbersSum);
		 
		 //Skip 5 nos & then find sum
		 
		 Integer skSum =  list.stream().skip(5).reduce((a,b) -> a+b).get();

		 System.out.println("Sum of  numbers excluding first five numbers is "+skSum);

	}

	public static void doSorting() {
		List<Integer> list = Arrays.asList(-1, 0, 2, 222, 234, 890, 567, 432, 236, 22);

		List<Integer> sortedList = list.stream().sorted().collect(Collectors.toList());
		System.out.println("Sorted List in Asc order is ");
		sortedList.forEach(System.out::println);

		List<Integer> sortedListDesc = list.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
		System.out.println("Sorted List in desc order is ");
		sortedListDesc.forEach(System.out::println);
	}

	public static void findMinMax() {
		List<Integer> list = Arrays.asList(-1, 0, 2, 222, 234, 890, 567, 432, 236, 22);

		Integer min = list.stream().min(Comparator.comparing(e -> e)).get();
		System.out.println("Min number " + min);

		Integer max = list.stream().max(Comparator.comparing(Integer::valueOf)).get();
		System.out.println("Max Number " + max);
	}

	private static void FindDuplicateNumbers() {
		List<Integer> list = Arrays.asList(3, 3, 5, 7, 5, 7, 9, 10, 12, 12, 14, 14, 0);
		Set<Integer> duplicateNumbers = list.stream().filter(e -> Collections.frequency(list, e) > 1)
				.collect(Collectors.toSet());

		System.out.println("duplicateNumbers are " + duplicateNumbers);

		Set<Integer> dupNum = new HashSet<Integer>();
		Set<Integer> duplicateNumbersUsingSet = list.stream().filter(e -> !dupNum.add(e)).collect(Collectors.toSet());

		System.out.println("duplicateNumbersUsingSet are " + duplicateNumbersUsingSet);

		// Set add() method returns True if the element is not present in the
		// set and is new.

	}

	private static void PrintNumbersStartsWithPrefix2() {
		List<Integer> numbers = Arrays.asList(2, 222, 234, 890, 567, 432, 236, 22);

		List<Integer> results = numbers.stream().map(num -> String.valueOf(num)).filter(num -> num.startsWith("2"))
				.map(Integer::valueOf).collect(Collectors.toList());

		System.out.println("Numbers with Prefix 2 are : " + results);

	}

	private static void PrintEvenAndOddNumbers() {

		List<Integer> numbers = Arrays.asList(11, 2, 3, 45, 67, 9, 90, 87, 8, 2);
		List<Integer> evenList = numbers.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());
		System.out.println("even nos are : " + evenList);

		List<Integer> oddList = numbers.stream().filter(num -> num % 2 != 0).collect(Collectors.toList());
		System.out.println("odd nos are : " + oddList);

	}

	private static void NumberSquareAverage() {
		List<Integer> list = Arrays.asList(1, 10, 20, 30, 15);
		// 1 100 400 900 225 Square of each number
		// 400 900 225 filtering nos which are greater than 100
		// 1525/3 = 508.333 Taking Average

		double average = list.stream().map(num -> num * num).filter(num -> num > 100).mapToInt(s -> s).average()
				.getAsDouble();

		System.out.println("average after square and filter is " + average);
	}

	private static void printAverageOfAllNumbers() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		double average = list.stream().mapToInt(s -> s).average().getAsDouble();
		System.out.println("average is " + average);
	}

	private static void printSumOfAllNumbers() {

		List<Integer> list = Arrays.asList(1, 2, 3, 4);
		Optional<Integer> sum = list.stream().reduce((a, b) -> a + b);
		System.out.println("Sum is " + sum.get());
	}
}
