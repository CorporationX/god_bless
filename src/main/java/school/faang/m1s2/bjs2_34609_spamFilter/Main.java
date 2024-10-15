package school.faang.m1s2.bjs2_34609_spamFilter;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

        MessageFilter spamFilter = message -> !message.toLowerCase().contains("спам");
        MessageFilter lengthFilter = message -> message.length() > 10;
        MessageFilter emojiFilter = message -> !message.contains("😀");
        MessageFilter exclamationFilter = message -> !message.contains(("!!!"));

        List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter, emojiFilter, exclamationFilter);

        String[] messages = {"Привет!", "Это спам!", "Как дела? 😀", "Уникальное предложение!!!",
                "Длинное сообщение без спама и эмодзи", "Длинное сообщение без слона и эмодзи"};

        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            System.out.println("Сообщение: " + message + " | Пропущено: " + isFiltered);
        }
    }
}
