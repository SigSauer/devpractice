package com.sigsauer.devpractice.salestelegrambot;

import com.google.gson.Gson;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Bot extends TelegramLongPollingBot {
    private Map<String, String> config;


    private Long chat;
    private Map<String, Integer> messages = new HashMap<>();

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        System.out.println("??????????????????????????\n"+update.toString()+"\n?????????????????????????????????");
        if (update.hasMessage() && message.hasText()) {
            System.out.println("<message> username: "+message.getFrom().getUserName()+ " text: "+message.getText());
            if (message.getChat().isGroupChat()) {
                if (chat == null) {
                    chat = message.getChatId();
                    System.out.println("<action> set chatId " +chat);
                }
                if (message.getText().equals("/stat")) {
                    System.out.println("<action> get statistics");
                    send(chat, messages.toString());
                } else if (message.getFrom().getBot()) {
                    System.out.println("<action> Bot detected!");
                    add(message.getText());
                }
            }
        }
    }

    private synchronized void add(String text) {
        if(messages.containsKey(text)) {
            System.out.println("<action> Message storage Iteration");
            Integer count = messages.get(text);
            System.out.println(messages.replace(text, count, count + 1));
            send(chat, "Баян");
        }else {
            System.out.println("<action> Message storage Putting");
            System.out.println(messages.put(text, 1));
            send(chat, "О, что-то новенькое");
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
        String path = "salestelegrambot/src/main/resources/messagebot.json";

        try {
            return new Gson().fromJson(new BufferedReader(new FileReader(path)), HashMap.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }



}
