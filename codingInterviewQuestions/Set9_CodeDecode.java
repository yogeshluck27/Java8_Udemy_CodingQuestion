package codingInterviewQuestions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Set9_CodeDecode {
	public static void main(String[] args) {
		int[] numbers = { 5, 2, 8, 3, 1 };
		int[] numbers1 = { 5, 2, 8, 1, 1 };
		int[] numbers2 = { 5 };
		//fetchSecondSmallest(numbers);
		//fetchSecondSmallestFromDuplicate(numbers1);
		//fetchSecondSmallestWithExceptionHandling(numbers2);
		
		System.out.println("****************************************");
		int[] arr1 = {1,2,3,4,5};
		int[] arr2 = {4,5,6,7,8};

		fetchCommonElements(arr1, arr2);
		
		System.out.println("****************************************");

		reverseGivenArrayInPlace(arr1);
		
		System.out.println("****************************************");
		
		String[] strings = {"Apple","Banana","Avocado","Apricot","Grapes"};
		findLengthOfLongestString(strings);
		findStringWithLongestLength(strings);
	}

	private static void fetchSecondSmallest(int[] numbers) {
		int secondSmallest = Arrays.stream(numbers).sorted().skip(1).findFirst().getAsInt();
		System.out.println("secondSmallest is " + secondSmallest);
	}

	private static void fetchSecondSmallestFromDuplicate(int[] numbers) {
		int secondSmallest = Arrays.stream(numbers).distinct().sorted().skip(1).findFirst().getAsInt();
		System.out.println("secondSmallest from Duplicate Array is " + secondSmallest);
	}

	private static void fetchSecondSmallestWithExceptionHandling(int[] numbers2) {
		int secondSmallest = Arrays.stream(numbers2).distinct().sorted().skip(1).findFirst()
				.orElseThrow(() -> new IllegalArgumentException("Array does not contain second smallet element"));
		System.out.println("secondSmallest from  Array is " + secondSmallest);
	}

	private static void fetchCommonElements(int[] arr1, int[] arr2) {
		
		List<Integer> commonElements = Arrays.stream(arr1).filter(number -> 
										Arrays.stream(arr2)
										.anyMatch(number2 -> number == number2))
										.boxed()  //This will convert int to Integer
										.collect(Collectors.toList());
		
		//.boxed() is converting int type elements to Integer
		//If we don't do it will get casting exception while doing Collectors.toList
		
		System.out.println("commonElements in both arrays is "+commonElements);
	}
	
	private static void reverseGivenArrayInPlace(int[] arr1) {
		IntStream.range(0, arr1.length/2).forEach(i -> {
			int temp = arr1[i];
			arr1[i] = arr1[arr1.length-i-1];  //5-0-1 , 5-1-1 , 5-2-1
			arr1[arr1.length-i-1] = temp;
			
		});
		
		System.out.println("Array after inplace Reversal is "+Arrays.toString(arr1));
	}
	

	

	private static void findLengthOfLongestString(String[] strings) {
		//Here we will replace every element by its length 
		int maxLength = Arrays.stream(strings).mapToInt(s -> s.length()).max().getAsInt();
		int maxLength1 = Arrays.stream(strings).mapToInt(s -> s.length()).max().orElse(0);

		System.out.println("maxLength in given String array is "+ maxLength);
		System.out.println("maxLength in given String array is "+ maxLength1);

	

	}
	
	private static void findStringWithLongestLength(String[] strings) {
		String MaxLengthWord = Arrays.stream(strings).reduce((s1,s2) -> s1.length() > s2.length() ? s1 : s2).get();
		System.out.println("MaxLengthWord "+ MaxLengthWord);	}

}
