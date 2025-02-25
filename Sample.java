package com.pratice;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sample {

    public static void main(String[] args) {

        System.out.println("Get common numbers");

        List<Integer> listOne=new ArrayList<>(Arrays.asList(1,2,3,4,5,6,2,3,5,7));
        List<Integer> listTwo=Arrays.asList(1,2,2,5,6,7,8,5);

        System.out.println( listOne.stream().filter(listTwo::contains).distinct().toList() );

        List<Integer> listThree= new ArrayList<>();

        for(Integer i: listOne) {

            for(Integer j: listTwo){

                if(Objects.equals(i, j))
                    listThree.add(j);

            }

        }

        System.out.println("Remove Duplicate numbers");

        // using Hashset
        Set<Integer> set = new HashSet<>(listThree);

        System.out.println(set);

        List<Integer> listFour= new ArrayList<>();

        for (Integer i: listThree) {

            if(!listFour.contains(i))
                listFour.add(i);
        }

        System.out.println(listFour);

        System.out.println("-----------------------------------");

        System.out.println("Merge of two lists");

         listOne.addAll(listTwo);

        System.out.println( Stream.concat(listOne.stream(), listTwo.stream()).toList() );


        System.out.println("-----------------------------------");

        System.out.println("count frequency of elements");

        System.out.println( listOne.stream().collect(Collectors.groupingBy(n -> n, Collectors.counting())) );

        Map<Integer, Integer> map = new HashMap<>();

        for(int i: listOne){

            if(map.containsKey(i))
                map.put(i, map.get(i)+1);
            else
                map.put(i, 1);

        }

        System.out.println(map);

        System.out.println("-----------------------------------");

        System.out.println("Reverse a string");

        String s = "Madhu";
        String[] arr = s.split("");
        String reverse ="";
        for(int i = arr.length-1; i>=0; i--) {
            reverse = reverse.concat(arr[i]);
        }
        System.out.println(reverse);

        System.out.println( new StringBuilder(s).reverse().toString() );
        System.out.println( new StringBuffer(s).reverse().toString() );


        System.out.println("-----------------------------------");

        System.out.println("Swap Two Numbers: Swap two numbers without using a third variable.");
        int a = 10;
        int b = 20;

        a = a+b; // 30
        b = a-b; // 10
        a = a-b; // 20
        System.out.println(a +" " +b);

        System.out.println("string contains any vowels.");

        List<String> vowels = Arrays.asList("a","e", "i", "o", "u");

        String v = "ELEPHANT";

        System.out.println( Arrays.stream(v.split(""))
                        .map(String::toLowerCase)
                        .filter(vowels::contains).toList() );

        System.out.println("-----------------------------------");

        System.out.println("Prime");

        int[] num = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        System.out.println(Arrays.toString(Arrays.stream(num).filter(n -> n % 2 == 0).toArray()));

        System.out.println("-----------------------------------");

        System.out.println("Palindrome");

        String palindrome = "civic";

        System.out.println(new StringBuilder(palindrome).reverse().toString().equalsIgnoreCase(palindrome));

        System.out.println("-----------------------------------");

        System.out.println("Second Largest Number in an Array");

        int[] ar = {129, 146, 456, 654, 789, 356};

        System.out.println( Arrays.stream(ar).sorted().toArray() [ar.length - 2] );

        Arrays.sort(ar);

        System.out.println( ar[ar.length - 2] );

        // Descending order sorting

        ar = Arrays.stream(ar).boxed().sorted(Collections.reverseOrder())
                        .mapToInt(Integer::intValue).toArray();

        System.out.println( ar[1] );

        System.out.println("-----------------------------------");

        System.out.println("Find the First Non-Repeating Character in a String");

        String repeat = "enter";

        Map<Character, Integer> nonRepeatMap = new LinkedHashMap<>();

        for(char c : repeat.toCharArray()) {
            nonRepeatMap.put(c, nonRepeatMap.getOrDefault(c, 0)+1);
        }

        System.out.println(nonRepeatMap);

        System.out.println( getFirstNonRepeatingChar(nonRepeatMap) );

        System.out.println("using Arrays");

        int[] count = new int[Character.MAX_VALUE];

        for(char c: repeat.toCharArray()){
            count[c]++;
        }

        System.out.println( getFirstNonRepeatingChar(repeat, count) );

        System.out.println("-----------------------------------");

        System.out.println( "Sum of digits of a number" );

        int number = 56781;

        int sum = 0;

        for(; number!=0; ) {
            sum += number%10;
            number = number/10;
        }

        System.out.println(sum);

        number = 56781;

        number = Stream.of(String.valueOf(number).split(""))
                        .mapToInt(Integer::parseInt)
                        .sum();

        System.out.println(number);

        System.out.println("-----------------------------------");

        System.out.println("greatest among three numbers.");

        int[] numbers = {978, 987, 897, 345, 657, 999};

        System.out.println( Arrays.stream(numbers).max().getAsInt() );

        System.out.println("-----------------------------------");

        System.out.println("calculate the average of an array of integers");

        System.out.println( Arrays.stream(numbers).average().getAsDouble() );

        int size = numbers.length;
        int add = 0;

        for(int i : numbers)
            add+=i;

        System.out.println((double) add/size);

        System.out.println("-----------------------------------");


    }

    private static char getFirstNonRepeatingChar(String repeat, int[] count) {

        for(char c : repeat.toCharArray()){

            if(count[c] == 1)
                return c;

        }
        return '_';
    }

    private static char getFirstNonRepeatingChar(Map<Character, Integer> nonRepeatMap) {
        for(Map.Entry<Character, Integer> entry: nonRepeatMap.entrySet()) {
            if(Objects.equals(entry.getValue(), 1))
                return entry.getKey();
        }
        return '_';
    }

}
