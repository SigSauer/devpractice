package com.sigsauer.univ.testing;

import java.util.InputMismatchException;
import java.util.Scanner;
//LR 5
public class MathExecutor {

    public static void main(String[] args) {
        new MathExecutor().guide();
    }

    //1
    public void guide() {
        Scanner dSc = new Scanner(System.in);
        Scanner lSc = new Scanner(System.in);
        double x = 0, y = 0;

        try {
            //2
            System.out.println("Enter X");
            //3
            x = dSc.nextDouble();
            //4
            System.out.println("Enter Y");
            //5
            y = dSc.nextDouble();
            //12
        }catch (InputMismatchException e) {
            //13
            System.err.println("Wrong data input, try again");
            guide();
        }
        //6
        System.out.println("Entered data: x = "+ x +", y = "+ y);
        //8
        System.out.println("Result: a = "+ func(x, y));
        //9
        System.out.println("Do you want to terminate the program? (\"y\" - yes, otherwise - no");
        //10
        if(lSc.nextLine().equals("y")) {
            //11
            return;
        }else  {
            guide();
        }

    }

    public double func(double x, double y) {
        //7
        return (x * y + 2 * x - y) / ( x * y - 2 * x + y);
    }
}
