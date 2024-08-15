package spam;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

// Создание фильтров
        MessageFilter<String> spamFilter = message -> !message.toLowerCase().contains("spam");
        MessageFilter<String> lengthFilter = message -> message.length() > 10;
        MessageFilter<String> emojiFilter = message -> !message.contains(":)");

        List<MessageFilter<String>> filters = Arrays.asList(spamFilter, lengthFilter, emojiFilter);

// Обработка сообщений
        String[] messages = {"Hello world!", "It's spam", "How are you? :)", "Very long message without spam and emoji"};

        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            System.out.println("Message: " + message + " | Skipped: " + isFiltered);
        }
    }
}
