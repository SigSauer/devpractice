package com.sigsauer.devpractice;

import java.util.Arrays;
import java.util.Scanner;

public class MMP {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter A");
        int a[] =  new int[sc.nextInt()];
        System.out.println("a.length() = "+a.length+"\nenter B");

        int b[] = new int[sc.nextInt()];
        System.out.println(("b.length() = " + b.length));
        int[][] array = a.length > b.length ? new int[][] {{7}} : new int[][] {{0}};
        System.out.println("result array: ["+array[0][0]+"]");
    }
}
