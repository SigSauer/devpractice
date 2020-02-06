package com.sigsauer.devpractice.learning.gson;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

public class JsonController {

    public static Map<String, String> getJsonData(String path) {
        Map<String, String> values = null;
        BufferedReader br;
        Gson gson = new Gson();
        try {
            br = new BufferedReader(new FileReader(path));
            values = gson.fromJson(br, Map.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return values;
    }
}
