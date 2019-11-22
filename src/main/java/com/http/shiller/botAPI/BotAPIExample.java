package com.http.shiller.botAPI;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class BotAPIExample extends TelegramLongPollingBot {
    static {
        ApiContextInitializer.init();
    }

    {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(this);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new BotAPIExample();
    }


    @Override
    public void onUpdateReceived(Update update) {
        try {
            Message message = update.getMessage();
            String text = message.hasText() ?
                    message.getText()
                    : null;

            Long chatId = message.getChatId();
            if (chatId != null) {
                SendMessage sendMessage = new SendMessage(chatId, "Nu, u " + text);
                execute(sendMessage);
            }
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "Exmpl2Bot";
    }

    @Override
    public String getBotToken() {
        return "TOKEN";
    }
}
