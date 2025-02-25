package com.pratice;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalInterface {

    public static void main(String[] args) {

        /**--------------------------------------------------------------*/

        Predicate<Integer> eligible = age -> age>=18;
        System.out.println(eligible.test(23));

        Predicate<Integer> isEven = n -> n%2==0;
        Predicate<Integer> isGreater = n -> n>10;

        System.out.println(isEven.and(isGreater).test(10));
        System.out.println(isEven.or(isGreater).test(19));
        System.out.println(isEven.negate().test(7));

        System.out.println("----------------");

        /**--------------------------------------------------------------*/

        Function<Integer, Integer> add = x -> x+3;
        Function<Integer, Integer> multi = x -> x*x;

        System.out.println(add.andThen(multi).apply(3));
        System.out.println(add.compose(multi).apply(3));

        Function<Integer, Integer> identity = Function.identity();
        System.out.println(identity.apply(3));

        System.out.println("----------------");

        /**--------------------------------------------------------------*/

        Consumer<String> hello = s -> System.out.print("Hello....."+ s);
        Consumer<String> bye= s -> System.out.println(".....bye");

        hello.andThen(bye).accept("madhu");
        System.out.println("----------------");

    }
}