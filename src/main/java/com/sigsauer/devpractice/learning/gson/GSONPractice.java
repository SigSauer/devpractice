package com.sigsauer.devpractice.learning.gson;

import java.util.Arrays;
import java.util.Map;

public class GSONPractice {
    public static String path = "C:\\Users\\PDV00\\IdeaProjects\\devpractice\\src\\main\\resources\\gson\\bot.json";

    public static void main(String[] args)  {
        outputValue();
    }

    public static void outputValue(){
        System.out.println(Arrays.toString(JsonController.getJsonData(TwoString[].class, path)));


    }

    static class TwoString {
        String string1;
        String string2;

        TwoString(String string1, String string2) {
            this.string1 = string1;
            this.string2 = string2;
        }

        @Override
        public String toString() {
            return "TwoString{" +
                    "string1='" + string1 + '\'' +
                    ", string2='" + string2 + '\'' +
                    '}';
        }
    }
}
