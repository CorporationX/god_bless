package school.faang.spamfilter;

import java.util.List;
import java.util.Arrays;

public class App {
    private static final Integer LENGTH_FILTER = 10;

    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

        MessageFilter spamFilter = message -> !message.toLowerCase().contains("спам");
        MessageFilter lengthFilter = message -> message.length() > LENGTH_FILTER;
        MessageFilter emojiFilter = message -> !message.contains("😀");

        List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter, emojiFilter);

        String[] messages = {"Привет!", "Это спам!", "Как дела? 😀", "Длинное сообщение без спама и эмодзи"};

        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            System.out.printf(("Сообщение: %s | Прошло все фильтры: %s%n"), message, isFiltered);
        }
    }
}