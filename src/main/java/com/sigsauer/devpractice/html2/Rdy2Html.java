package com.sigsauer.devpractice.html2;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Rdy2Html {

    String rdyFile = "C:\\Users\\PDV00\\IdeaProjects\\devpractice\\src\\main\\resources\\html2\\all.html";
    String tFile = "C:\\Users\\PDV00\\IdeaProjects\\devpractice\\src\\main\\resources\\html2\\mtest.html";
    String directory = "C:\\Users\\PDV00\\IdeaProjects\\devpractice\\src\\main\\resources\\html2\\";
    BufferedWriter bw;

    String start = "Previous messages"; //+27
    String end = "Next messages"; //-136 chars
    String prefix = "", suffix = "";



    public static void main(String[] args) throws IOException, ParseException {
        //int a = Integer.parseInt(Pattern.compile("[0-9]+").matcher("messages2.html").group()group());
        //System.out.println(a+20);
        //new Rdy2Html().launch();
    }

    private void launch() throws IOException {

        bw = Files.newBufferedWriter(Paths.get(tFile),
                StandardOpenOption.APPEND);
        List<Path> files = new ArrayList<>();
        //Files.newDirectoryStream(Path.of(URI.create(directory)).forEach(files::add));
        files.sort(Comparator.comparingInt(p -> Integer.parseInt(p.toString())));
//        path -> {
//                    String content = Files.readString(path);
//                    bw.write(content.substring(content.indexOf(start)+27,content.indexOf(end)-136));
//                    bw.newLine();
//        });

//                bw.write(c);
//                bw.newLine();
//        bw.close();

        }

    }
