package com.pratice;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    private static Map<Integer, Integer> fib = new HashMap<>();

    private static int fibonacci(int i) {

        if(i <= 1)
            return i;

        if(fib.containsKey(i))
            fib.get(i);

        int result = fibonacci(i-1) + fibonacci(i-2);
        fib.put(i, result);
        return result;

    }


    public static void main(String[] args) {

        int number = 10;

        for (int i=0; i<number; i++) {
            System.out.print(fibonacci(i) + " ");
        }

    }


}
