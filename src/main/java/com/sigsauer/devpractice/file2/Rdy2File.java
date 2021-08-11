package com.sigsauer.devpractice.file2;

import com.sigsauer.devpractice.html2.Rdy2Html;

import java.nio.charset.StandardCharsets;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Rdy2File {

    String ExplorePath = "C:\\Users\\PDV00\\IdeaProjects\\abc-development\\abc\\src\\main\\java\\com\\sigsauer\\univ\\abc";
    String masterFilePath = "C:\\Users\\PDV00\\IdeaProjects\\devpractice\\src\\main\\resources\\rdy2file\\Masterclass.java";

    Path masterFile;

    public static void main(String[] args) {
        new Rdy2File().launch();
    }

    public void launch() {
        List<Path> allPaths;
        try {
            allPaths = Files.walk(Paths.get(ExplorePath))
                    .filter(Files::isRegularFile)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        if(allPaths.isEmpty()) return;
        System.out.println("Found file paths: "+allPaths.size());

        Map<String, List<String>> headerBodyFiles = allPaths.stream()
                .collect(Collectors.toMap(
                        f -> ">"+f.getFileName(),
                        f -> {
                            List<String> strs = new ArrayList<>();
                            strs.add("\n\n"+f.getFileName());
                            try {
                                strs.addAll(Files.readAllLines(f, StandardCharsets.UTF_8));
                            } catch (IOException e) {
                                e.printStackTrace();
                                return Collections.emptyList();
                            }
                            return strs;
                        }));
        System.out.println("Header-Body Map created");



        masterFile = Paths.get(masterFilePath);

        System.out.println("Master file: "+masterFile);
        headerBodyFiles.forEach(this::write2master);
    }

    public void write2master(String header, List<String> body) {

        body = body.stream()
                .filter(s -> !(s.contains("import") || s.contains("package")))
                .collect(Collectors.toList());

        try {
            Files.write(masterFile, body, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            System.out.println("File "+header.substring(1)+" write successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
