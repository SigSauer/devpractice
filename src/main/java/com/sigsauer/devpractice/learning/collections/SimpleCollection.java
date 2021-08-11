package com.sigsauer.devpractice.learning.collections;

import com.sigsauer.devpractice.learning.gson.Human;

import java.util.LinkedList;
import java.util.List;

public class SimpleCollection {
    public static void main(String[] args) {
        Human h1 = new Human("h1", "umands");
        Human h2 = new Human("h2", "umsdfgadsfands");
        Human h3 = new Human("h3", "umaasdfqwernds");
        List<Human> humans = new LinkedList<>();
        humans.add(h1);
        humans.add(h2);
        humans.add(h3);


    }
}
