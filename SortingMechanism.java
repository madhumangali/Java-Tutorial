package com.pratice;

import java.util.Arrays;

public class SortingMechanism {

    public static void main(String[] args) {

        System.out.println("Selection sort ");

        int[] ar = {129, 146, 456, 654, 789, 356};

        for (int i = 0; i<ar.length; i++){

            int maxIndex = i;

            for(int j= i+1; j<ar.length; j++){

                if(ar[i] < ar[j]) {
                    maxIndex = j;
                }

            }

            int ele = ar[maxIndex];
            ar[maxIndex] = ar[i];
            ar[i] = ele;

        }

        Arrays.stream(ar).forEach(System.out::println);
        System.out.println("---------------------------------------");

        System.out.println("Bubble Sort");

        int[] arr = {129, 146, 456, 654, 789, 356};

        for(int i=0; i< arr.length-1; i++){

            for(int j=0; j< arr.length-i-1; j++ ){

                if(arr[j] < arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }

        }
        Arrays.stream(arr).forEach(System.out::println);
        System.out.println("---------------------------------------");


    }

}
