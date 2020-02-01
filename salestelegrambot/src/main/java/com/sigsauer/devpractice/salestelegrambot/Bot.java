package com.sigsauer.devpractice.salestelegrambot;

import org.json.JSONObject;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

public class Bot extends TelegramLongPollingBot {
    private final String BOT_USERNAME = "tcparser_bot";
    private final String BOT_TOKEN = "771505932:AAHRbOgKsQqPvIJWFvzV17N3x6QSmSxTq2U";


    @Override
    public void onUpdateReceived(Update update) {
        messageController(update.getMessage());
    }

    private synchronized void messageController(Message message) {
        if(message.getText().equals("/start")) send(message,"Hello, my friend!");
    }

    private void send(Message message, String text) {
        SendMessage sendMessage = new SendMessage(message.getChatId(),text);
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
