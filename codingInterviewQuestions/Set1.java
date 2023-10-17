package codingInterviewQuestions;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Set1 {

	static List<Integer> list = Arrays.asList(3,3,5,7,5,7,9,10,12,12,14,14,0);
	
	public static void main(String[] args) {
		//findDuplicateNumbers();
		//findMinMax();
		//doSorting();
		//findsecondHigheshtAndLowestNumber();
		//printEvenAndOddNumbers();
		findAverageOfNumbers();
	}
	public static void  findDuplicateNumbers(){
		Set<Integer> duplicateNumbers = list.stream().filter(e->Collections.frequency(list, e)>1)
				.collect(Collectors.toSet());
		System.out.println("Duplicate Numbers are ");
		duplicateNumbers.forEach(System.out::println);
	}
	public static void findMinMax(){
		Optional<Integer> min = list.stream().min(Comparator.comparing(Integer::valueOf));
		System.out.println("Min number "+min.get());
		
		Optional<Integer> max = list.stream().max(Comparator.comparing(Integer::valueOf));
		System.out.println("Max Number "+max.get());
	}
	public static void doSorting(){
		
		List<Integer> sortedList = list.stream().sorted().collect(Collectors.toList());
		System.out.println("Sorted List in Asc order is ");
		sortedList.forEach(System.out::println);
		
		List<Integer> sortedListDesc = list.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
		System.out.println("Sorted List in desc order is ");
		sortedListDesc.forEach(System.out::println);
	}
	public static void findsecondHigheshtAndLowestNumber(){
		
		Integer secondHigestNumber = list.stream().sorted(Collections.reverseOrder()).distinct().skip(1).findFirst().get();
		System.out.println("secondHigestNumber is "+secondHigestNumber);
		
		Integer secondLowestNumber = list.stream().sorted().distinct().skip(1).findFirst().get();
		System.out.println("secondLowestNumber is "+secondLowestNumber);
		
	}
	public static void printEvenAndOddNumbers(){
		
		List<Integer> evenNoList = list.stream().distinct().filter(num -> num%2==0).collect(Collectors.toList());
		System.out.println("Print even no list");
		evenNoList.forEach(System.out::println);
	}
	public static void findAverageOfNumbers(){
		Double average = list.stream().collect(Collectors.averagingInt(Integer::valueOf));
		System.out.println("Average of numbers is "+average);
		
		Double average1 = list.stream().mapToInt(e->e).average().getAsDouble();
		System.out.println("Average of numbers using second approach is "+average1);

	}
}
