package com.sigsauer.devpractice.learning.gson;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

public class JsonController {

    public static <T> T[] getJsonData(Class<T[]> t,String path) {
        T[] values = null;
        BufferedReader br;
        Gson gson = new Gson();
        try {
            br = new BufferedReader(new FileReader(path));
            values = gson.fromJson(br, t);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return values;
    }
}
