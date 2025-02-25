package com.pratice;

import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number");
        int num = scanner.nextInt();
        scanner.close();

        factorialIterative(num);
        System.out.println(factorialRecursive(num));

    }

    private static void factorialIterative(int num) {
        int fact = 1;

        for(int i = 1; i<= num; i++){

            fact *= i;

        }
        System.out.println(fact);
    }

    private static int factorialRecursive(int num) {

      if( num==0 || num==1)
          return 1;

        return num * factorialRecursive(num-1);

    }



}
