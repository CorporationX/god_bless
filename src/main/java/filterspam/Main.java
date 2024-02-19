package filterspam;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        MessageProcessor messageProcessor = new MessageProcessor();

        // Создание фильтров
        MessageFilter spamFilter = message -> !message.toLowerCase().contains("спам");
        MessageFilter lengthFilter = message -> message.length() > 10;
        MessageFilter emojiFilter = message -> !message.contains("😀");
        MessageFilter fckFilter = message -> !message.contains("fck");

        List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter, emojiFilter, fckFilter);

        // Обработка сообщений
        String[] messages = {"Привет!", "Это спам!", "Как дела? 😀", "Длинное сообщение без спама и эмодзи"};
        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            System.out.println("Сообщение: " + message + " | Пропущено: " + isFiltered);
        }
    }
}
