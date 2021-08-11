package com.sigsauer.univ.testing;

import java.util.*;
//LR 10
public class ArrayRunner {

    public static void main(String[] args) {
        new ArrayRunner().guide();
    }

    //Module 1. General
    public void guide() {
        int[] A = arrayScanner();
        int[] B = arrayScanner();
        if(A.length != B.length) {
            System.err.println("Arrays must be same length");
        }else {
            System.out.println("Array A: "+ Arrays.toString(A));
            System.out.println("Array B: "+ Arrays.toString(B));
            int[] C = arrayGenerator(A, B);
            System.out.println("Array C: "+ Arrays.toString(C));
            System.out.println("Array sorted C: "+ Arrays.toString(arraySorter(C)));
        }

    }

    //Module 2. Input
    public int[] arrayScanner() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array length");
        int[] array = new int[sc.nextInt()];
        System.out.println("Input values (throw Enter)");
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }
        return array;
    }

    //Module 3. Generate new array
    public int[] arrayGenerator(int[] A, int[] B) {
        int[] array = new int[A.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.max(A[i],B[i]);
        }
        return array;
    }

    //Module 4. Sort array
    public int[] arraySorter(int[] array) {
        List<Integer> sorted = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if(array[i] % 2 == 0) sorted.add(array[i]);
        }
        return sorted.stream().mapToInt(Integer::intValue).toArray();
    }

    //Output stub
    public void outputStub() {
        System.out.println("Text (output stub)");
    }

    //Output array stub
    public void outputArrayStub(int[] array) {
        System.out.println("Array: "+Arrays.toString(array));
    }

}
