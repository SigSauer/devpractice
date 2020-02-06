package com.sigsauer.devpractice.salestelegrambot;

import com.google.gson.Gson;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bot extends TelegramLongPollingBot {
    private Map<String, String> config;

    @Override
    public void onUpdateReceived(Update update) {
        Scanner sc = new Scanner(System.in);
        String question = update.getMessage().getText();
        System.out.println(question);
        if (question.equals("/start")) {
            send(update.getMessage().getChatId(), "a");
        } else {
            System.out.println(":");
            String answer = sc.nextLine();
            send(update.getMessage().getChatId(), answer);
        }
    }


    private synchronized void send(Long chatId, String text) {
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
        return config.get("username");
    }

    @Override
    public String getBotToken() {
        return config.get("token");
    }

    public Bot() {
        this.config = getConfig();
    }

    private Map getConfig() {
        String path = "salestelegrambot/src/main/resources/bot.json";

        try {
            return new Gson().fromJson(new BufferedReader(new FileReader(path)), HashMap.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }



}
