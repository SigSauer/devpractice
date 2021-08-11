package com.sigsauer.univ.testing;
//LR 9
public class PointInFigures {

    public static void main(String[] args) {
        System.out.println("Figure 1");
        figure1(2,0);
        figure1(2,2);
        figure1(4,3);
        figure1(4,2);
        figure1(0,2);
        figure1(2,1);
        figure1(3,3);
        figure1(2,4);

        System.out.println("Figure 2");
        figure2(0,9);
        figure2(2,0);
        figure2(3,3);
        figure2(2,3);
        figure2(1,3);
        figure2(2,4);
        figure2(3,2);
        figure2(1,5);

    }



    public static void figure1(int x, int y) {
        System.out.println("Point x: "+ x +", y: "+ y);
        //semicircle
        if (x <= 6 && Math.pow(x-6,2) + Math.pow(y-3,2) <= 1) System.out.println("Point in the semicircle");
        //left rectangle
        else if (x >= 3 && y >= 0 && x <= 6 && y <= 6) System.out.println("Point in the left rectangle");
        //right rectangle
        else if (x >= 6 && y >= 0 && x <= 10 && y <= 6) System.out.println("Point in the right rectangle");
        else System.out.println("Point outside any figures");
    }

    public static void figure2(int x, int y) {
        System.out.println("Point x: "+ x +", y: "+ y);
        //circle
        if (Math.pow(x, 2) + Math.pow(y, 2) <= Math.pow(2.5, 2)) System.out.println("Point in the circle");
        else System.out.println("Point outside th circle");
    }
}
