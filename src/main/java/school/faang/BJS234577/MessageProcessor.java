package school.faang.BJS234577;

import java.util.Arrays;
import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> filters) {
        if (message.isEmpty() || message.isBlank()) {
            throw new IllegalArgumentException("Are you serious, where is your message?");
        }

        for (MessageFilter messageFilter : filters) {
            messageFilter.filter(message);
            if (!messageFilter.filter(message)) {
               return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

// Фильтры
        MessageFilter spamFilter = message -> !message.toLowerCase().contains("спам");
        MessageFilter lengthFilter = message -> message.length() > 10;
        MessageFilter emojiFilter = message -> !message.contains("😀");

// Список фильтров
        List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter, emojiFilter);

// Входящие сообщения
        String[] messages = {"Привет!", "Это спам!", "Как дела? 😀", "Длинное сообщение без спама и эмодзи"};

// Обработка сообщений
        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            System.out.println("Сообщение: " + message + " | Пропущено: " + isFiltered);
        }
    }
}
