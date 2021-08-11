package com.sigsauer.devpractice.learning.parsing;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;

public class SimpleParsing {
    public static void main(String[] args) throws IOException {

        Document doc = Jsoup.connect("https://ecologyknu.wixsite.com/ecologymanual/").get();

        // Elements extends ArrayList<Element>.
        Elements aElements = doc.getElementsByTag("a");


        try(FileWriter writer = new FileWriter("C:\\Users\\PDV00\\IdeaProjects\\devpractice\\src\\main\\resources\\parsing\\links.txt", true)) {
            String rdy = "rdy 1";
            writer.write(rdy);


            for (Element aElement : aElements) {
                String href = aElement.attr("href");
                String text = aElement.text();

                System.out.println(text);
                System.out.println("\t" + href);
                writer.write(text+"\n\t"+href);
            }
        }
    }
}
