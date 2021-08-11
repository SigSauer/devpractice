package com.sigsauer.devpractice.learning.parsing;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Rdy2HtmlParsing {
    List<Rdy2Subject> subjects;
    FileWriter writer;
    String file = "C:\\Users\\PDV00\\IdeaProjects\\devpractice\\src\\main\\resources\\parsing\\total\\rdy3.txt";

    public void launch() throws IOException {
        writer = new FileWriter(file, true);
        print("rdy2parse");
        findPages();
        subjects.forEach(this::parse);
        subjects.forEach(this::print);
        print("/rdy");
        writer.flush();
    }

    private void findPages() throws IOException {
        subjects = new ArrayList<>();
        Connection conn = Jsoup.connect("https://ecologyknu.wixsite.com/ecologymanual/");

        Document doc = conn.get();
        Elements topHref = doc.getElementsByAttributeValueContaining("href","ecologymanual");

        topHref.forEach(e -> {
            try {
                Jsoup.connect(e.attr("href")).get().
                        getElementsByAttributeValueContaining("href","ecologymanual").forEach(l -> {
                            Rdy2Subject tempRdy2 = Rdy2Subject.
                                    titleReader(l.text(),l.attr("href"));
                            if(tempRdy2 != null) {
                                subjects.add(tempRdy2);
                            }
                });
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

//        for (Element e: topHref) {
//            print(e.text() + ": " + e.attr("href"));
//
//            Document lowDoc = Jsoup.connect(e.attr("href")).get();
//            Elements lowHref = lowDoc.getElementsByAttributeValueContaining("href","ecologymanual");
//
//            for (Element ee: lowHref) {
//                print(ee.text() + ": " + ee.attr("href"));
//                hrefs.add(ee.attr("href"));
//            }
//        }
//        return hrefs;
    }

    private void parse(Rdy2Subject subject) {
        try {
            Document hrefDoc = Jsoup.connect(subject.getPage()).get();
            hrefDoc.getElementsByClass("txtNew").forEach(el -> {
                if(!el.text().contains("Online") && el.text() != null)
                subject.addContent(el.text());
            });
            hrefDoc.getElementsByTag("img").forEach(im -> subject.addImage("\""+im.attr("src")+"\""));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void print(String text) {
        text += "\n\n";
        try {
            System.out.println(text);
            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void print(Rdy2Subject subject) {
        print(subject.toString());
    }

    public static void main(String[] args) throws IOException {
        new Rdy2HtmlParsing().launch();
    }





}
