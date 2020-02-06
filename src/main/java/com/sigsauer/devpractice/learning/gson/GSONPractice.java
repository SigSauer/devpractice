package com.sigsauer.devpractice.learning.gson;

import java.util.Map;

public class GSONPractice {
    public static String path = "C:\\Users\\PDV00\\IdeaProjects\\devpractice\\src\\main\\resources\\gson\\data.json";

    public static void main(String[] args)  {
        outputValue();
    }

    public static void outputValue(){
        Map<String, String> json = JsonController.getJsonData(path);
        System.out.println(json.get("name")+" "+json.get("surname"));
    }


}
