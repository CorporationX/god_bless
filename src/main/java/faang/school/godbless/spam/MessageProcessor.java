package faang.school.godbless.spam;

import java.util.Arrays;
import java.util.List;

public class MessageProcessor {
    private boolean processMessage(String message, List<MessageFilter> filters) {
        for (MessageFilter filter : filters) {
            if (filter.filter(message)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

        // Создание фильтров
        MessageFilter spamFilter = message -> !message.toLowerCase().contains("спам");
        MessageFilter lengthFilter = message -> message.length() > 10;
        MessageFilter emojiFilter = message -> !message.contains("?");

        List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter, emojiFilter);

        // Обработка сообщений
        String[] messages = {"Привет!", "Это спам!", "Как дела? ?", "Длинное сообщение без спама и эмодзи"};

        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            System.out.println("Сообщение: " + message + " | Пропущено: " + isFiltered);
        }
    }
}


