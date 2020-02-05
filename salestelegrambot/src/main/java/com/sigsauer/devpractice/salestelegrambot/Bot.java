package com.sigsauer.devpractice.salestelegrambot;

import org.json.JSONObject;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;
import java.util.Scanner;

public class Bot extends TelegramLongPollingBot {
    private final String BOT_USERNAME = "";
    private final String BOT_TOKEN = "";

    Scanner sc = new Scanner(System.in);


    @Override
    public void onUpdateReceived(Update update) {
        String question = update.getMessage().getText();
        System.out.println(question);
        if(question.equals("/start")) {
            send(update.getMessage().getChatId(), "Люблю тебя!");
        }else {
            System.out.println(":");
            String answer = sc.nextLine();
            send(update.getMessage().getChatId(),answer);
        }
    }


    private synchronized
    void send(Long chatId, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(text);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String getBotUsername() {
        return BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    private String getConfiguration(String article) {
        JSONObject object = new JSONObject("resources/botconfig.json");
        return object.getString(article);
    }
}
