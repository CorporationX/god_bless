package school.faang.spamfilter;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();
        MessageFilter spamFilter = message -> !message.toLowerCase().contains("спам");
        MessageFilter lengthFilter = message -> message.length() > 10;
        MessageFilter emojiFilter = message -> !message.contains("😀");

        List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter, emojiFilter);

        String[] messages = {"Привет!",
                "Это спам!",
                "Test Passed",
                "Как дела? 😀",
                "Длинное сообщение без спама и эмодзи",
                "Good Message"};

        // Обработка сообщений
        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            System.out.println("Сообщение: " + message + " | Пропущено: " + isFiltered);
        }
    }
}