package com.sigsauer.univ.testing;

import java.util.InputMismatchException;
import java.util.Scanner;
//LR 7
public class TriangleType {
    /*
    equilateral - рівносторонній
    isosceles - рівнобедрений
    rectangular - прямокутний
    versatile - різносторонній
     */

    public static void main(String[] args) {
        new TriangleType().guide();
    }

    public void guide() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("input a");
            int a = sc.nextInt();
            System.out.println("input b");
            int b = sc.nextInt();
            System.out.println("input c");
            int c = sc.nextInt();
            if(a <= 0 || b <= 0 || c <= 0) {
                System.err.println("Inputted non-positive value(s)");
                return;
            }
            System.out.print("Triangle with sides: a = " + a + ", b = " + b + ", c = " + c + " is " +
                    checkTriangle(a, b, c));
        } catch (InputMismatchException e) {
            System.err.println("Wrong data input");
        }
    }

    public String checkTriangle(int a, int b, int c) {
        //existence check
        if(a >= b + c || b >= a + c || c >= a + b) return "not exist";
        //equilateral check
        if(a == b && a == c) return "equilateral";
        //rectangular check
        if((a*a == b*b + c*c) || (c*c == a*a + b*b) || (b*b == a*a + c*c)) return "rectangular";
        //isosceles check
        if(a == b || a == c || b == c) return "isosceles";

        return "versatile";
    }
}
