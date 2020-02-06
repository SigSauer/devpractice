package com.sigsauer.devpractice.learning.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

public class GSONPractice {
    BufferedReader bufferedReader;
    Gson gson;

    public String path = "C:\\Users\\PDV00\\IdeaProjects\\devpractice\\src\\main\\resources\\gson\\data.json";

    public static void main(String[] args) throws FileNotFoundException {
        GSONPractice practice = new GSONPractice();
        practice.outputValue();
        practice.outputObjectData();
    }

    public void outputValue() throws FileNotFoundException{
        bufferedReader = new BufferedReader(new FileReader(path));

        gson = new Gson();
        HashMap<String, String> json = gson.fromJson(bufferedReader, HashMap.class);
        System.out.println(json.get("name")+" "+json.get("surname"));
    }

    public void outputObjectData() throws FileNotFoundException {
        bufferedReader = new BufferedReader(new FileReader(path));
        gson = new Gson();
            Human human = gson.fromJson(bufferedReader, Human.class);
        System.out.println(human.toString());
    }
}
