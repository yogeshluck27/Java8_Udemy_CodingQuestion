package codingInterviewQuestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//https://www.youtube.com/watch?v=1Ps5F1PU72M
public class Set3_javaTechie {
		public static void main(String[] args) {
			//coutOccuranceOfCharacter();
			//findDuplicateElementFromString();
			//findSecondHighestElementInArray();
			//longestStringFromGivenArray();
			findElementStartsWith1();
			
		}
		
		private static void findElementStartsWith1() {
			int[] numbers = {5,9,11,2,8,21,1};
			List<String> stringList = Arrays.stream(numbers)
			.boxed()		//Stream<Integer>
			.map(s-> s+"") //Stream<String>
			.filter(s -> s.startsWith("1")) //Stream<String>
			.collect(Collectors.toList());  //List<String>
			System.out.println("Elements starts with 1 are : " +stringList);
		}

		private static void longestStringFromGivenArray() {

			String strArray[] = {"java" , "techie" , "springBoot" , "microservices"};
			String longestString = Arrays.stream(strArray)
					.reduce((word1 , word2) -> word1.length() > word2.length() ? word1 : word2 ) //BinaryOperator
					//takes two operands of same type & return value is also of same type
					.get();
			System.out.println("longestString in Array is "+longestString);
		}

		private static void findSecondHighestElementInArray() {

			int[] numbers = { 5 , 9 ,11 , 2 , 8 , 21 , 1};
			Integer secondHighest = Arrays.stream(numbers).boxed().sorted(Comparator.reverseOrder())
					.skip(1)
					.findFirst().get();
			System.out.println(secondHighest);
		}

		private static void findDuplicateElementFromString() {
			String input = "ilovejavatechie";
			List<String> duplicateElements = Arrays.stream(input.split(""))
					.collect(Collectors.groupingBy(s->s ,Collectors.counting()))
					.entrySet() //Set<Map<K,V>, Entry<String,Long>
					.stream()  //Stream<Map<K,V>.Entry<String,Long>>
					.filter(x->x.getValue()>1)
					.map(Map.Entry :: getKey) //Stream<String>
					.collect(Collectors.toList());
			System.out.println("duplicateElements are " + duplicateElements);
			
			
			List<String> uniqueElements = Arrays.stream(input.split(""))
					.collect(Collectors.groupingBy(s->s ,Collectors.counting()))
					.entrySet() //Set<Map<K,V>, Entry<String,Long>>
					.stream()  //Stream<Map<K,V>.Entry<String,Long>>
					.filter(x->x.getValue() ==1)
					.map(Map.Entry :: getKey) //Stream<String>
					.collect(Collectors.toList());
			
			System.out.println("uniqueElements are " + uniqueElements);
			
			String firstNonRepeatingElement = Arrays.stream(input.split(""))
					.collect(Collectors.groupingBy(s->s , LinkedHashMap :: new,Collectors.counting()))
					.entrySet()	//Set<Map<K,V>, Entry<String,Long>>
					.stream()  //Stream<Map<K,V>.Entry<String,Long>>
					.filter(x->x.getValue() ==1)
					.findFirst()
					.get()
					.getKey();
			//LinkedHashMap :: new -> we have to preserve insertion order
			System.out.println("firstNonRepeatingElement is " + firstNonRepeatingElement);

			String firstRepeatingElement = Arrays.stream(input.split(""))
					.collect(Collectors.groupingBy(s->s , LinkedHashMap :: new,Collectors.counting()))
					.entrySet()  //Set<Map<K,V>, Entry<String,Long>>
					.stream()  //Stream<Map<K,V>.Entry<String,Long>>
					.filter(x->x.getValue() > 1)
					.findFirst()
					.get()
					.getKey();
			//LinkedHashMap :: new -> we have to preserve insertion order
			System.out.println("firstRepeatingElement is " + firstRepeatingElement);
		}

		public static void coutOccuranceOfCharacter(){
			
			String input = "ilovejavatechie";
			
			Map<String,Long> map = Arrays.stream(input.split(""))
					.collect(Collectors.groupingBy(s->s ,Collectors.counting()));
			System.out.println(map);
		}
}
