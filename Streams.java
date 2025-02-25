package com.pratice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Streams {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("Madhu", "Mad");

        System.out.println("-------------------------------------------");

        /** map */

        List<List<String>> mappedList = list.stream()
                .map(s -> Arrays.asList(s.split(""))) // Each word becomes a String[]
                .toList();

        System.out.println(mappedList);

        System.out.println("-------------------------------------------");

        /** flatmap */
        List<String> flatmapList = list.stream()
                .flatMap( s -> Arrays.stream(s.split("") ) )
                .toList();

        System.out.println(flatmapList);

        System.out.println("-------------------------------------------");

        /** filter */

        list.stream().filter(s -> s.startsWith("M")).toList().forEach(System.out::println);

        System.out.println("-------------------------------------------");

        /** Function, Consumer, Supplier, Predicate, interface functional interfaces */

        String input = "Madhu";

        Function<String, String> inOne = (s1) -> s1.concat(" Mad");
        System.out.println(inOne.apply(input));

        Supplier<String> inTwo =() -> input.concat("hu");
        System.out.println(inTwo.get());

        Consumer<String> inThree = (s2) -> System.out.println(s2);
        inThree.accept(input);

        Predicate<String> inFour = s4 -> s4.startsWith("M");
        System.out.println(inFour.test(input));

        System.out.println("-------------------------------------------");

        /** Method Reference */

        Supplier<String> mRef = input::toUpperCase;
        System.out.println(mRef.get());

        System.out.println("-------------------------------------------");

        /** Stream & Parallel Stream */

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        names.stream().forEach(name -> System.out.println(Thread.currentThread().getName() +" - "+name));
        names.parallelStream().forEach(name -> System.out.println(Thread.currentThread().getName() +" - "+name));

        System.out.println("-------------------------------------------");

        /** distinct */

        list.stream().distinct();


    }


}
