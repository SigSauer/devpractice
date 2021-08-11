package com.sigsauer.devpractice.learning.parsing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rdy2Subject {
    private String number;
    private String article;
    private String page;
    private String content;
    private List<String> images = new ArrayList<>();

    public Rdy2Subject(String number, String article, String page, String content, List<String> images) {
        this.number = number;
        this.article = article;
        this.page = page;
        this.content = content;
        this.images.addAll(images);
    }

    public Rdy2Subject(String number, String article, String page, String content) {
        this.number = number;
        this.article = article;
        this.page = page;
        this.content = content;
    }

    public Rdy2Subject(String number, String article, String page) {
        this.number = number;
        this.article = article;
        this.page = page;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public static Rdy2Subject titleReader(String title, String page) {
        if(title.length() > 0 && title.charAt(0) >= '0' && title.charAt(0) <= '9')
            return new Rdy2Subject(title.substring(0, title.indexOf(' ')), title.substring(title.indexOf(' ')+1), page);
        return null;
    }

    public void addContent(String content) {
        this.content +="\n"+content;
    }

    public void addImage(String src) {
        this.images.add(src);
    }

    @Override
    public String toString() {
        return number +" "+ article +
                "\n\"" + page +
                "\"\n\n" + content +
                (!images.isEmpty() ? "\n\nImages:\n" + Arrays.toString(images.toArray()) : "");
    }
}


