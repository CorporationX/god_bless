package main.java.faang.school.godbless.spam;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

// Создание фильтров
        MessageFilter spamFilter = message -> !message.toLowerCase().contains("спам");
        MessageFilter lengthFilter = message -> message.length() > 5;
        MessageFilter emojiFilter = message -> !message.contains("😀");
        MessageFilter spammFilter = message -> !message.contains("spam");

        List<MessageFilter> filters = Arrays.asList(spamFilter,lengthFilter, emojiFilter, spammFilter);

// Обработка сообщений
        String[] messages = {"Привет!", "Это Жук", "Как дела? 😀", "Длинное сообщение без спама и эмодзи"};

        for (String message : messages) {
            messageProcessor.processMessage(message, filters);
            System.out.println("Сообщение: " + message + " | Пропущено: " + filters);
        }
    }
}
