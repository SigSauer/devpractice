package com.sigsauer.univ.testing;

import java.util.*;
//LR 6
public class FindMaxOfLocalMin {

    public static void main(String[] args) {
        int[] array1 = new int[] {2, 4, 3, 5, 2}; //1
        int[] array2 = new int[] {7, 2, 5, 0, -1, 9}; //1
        int[] array3 = new int[] {1, 2, 3, 4, 5, 6}; //1
        System.out.println("Array: "+Arrays.toString(array1));
        System.out.println("Max value of local min: "+ findMaxOfLocalMin(array1));

        System.out.println("Array: "+Arrays.toString(array2));
        System.out.println("Max value of local min: "+ findMaxOfLocalMin(array2));

        System.out.println("Array: "+Arrays.toString(array3));
        System.out.println("Max value of local min: "+ findMaxOfLocalMin(array3));
    }


    public static int findMaxOfLocalMin(int[] array) {
        List<Integer> mins = new ArrayList<>();

        if (array[0] < array[1]) //2
            mins.add(array[0]); //3
        if (array[array.length-1] < array[array.length-2]) //4
            mins.add(array[array.length-1]); //5
        for (int i = 1; i < array.length-1; i++) { //6
            if(array[i] < array[i-1] && array[i] < array[i+1]) //7
                mins.add(array[i]); //8
        }
        System.out.println("All local mins: "+mins.toString());
        int max = mins.get(0); //9
        for (Integer m : mins) { //10
            if (m > max) //11
                max = m; //12
        }

        return max; //13
    }
}
