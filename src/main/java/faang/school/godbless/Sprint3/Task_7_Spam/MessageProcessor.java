package faang.school.godbless.Sprint3.Task_7_Spam;

import java.util.Arrays;
import java.util.List;

public class MessageProcessor {
    public boolean processMessage (String message, List<MessageFilter> messageFilters) {
        return messageFilters.stream().allMatch(messageFilter -> messageFilter.filter(message));
    }

    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

// Создание фильтров
        MessageFilter spamFilter = message -> !message.toLowerCase().contains("спам");
        MessageFilter lengthFilter = message -> !(message.length() > 20);
        MessageFilter emojiFilter = message -> !message.contains("\\uD83D\\uDE00");

        List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter, emojiFilter);

// Обработка сообщений
        String[] messages = {"Привет!", "Это спам!", "Как дела? \\uD83D\\uDE00", "Длинное сообщение без спама и эмодзи"};

        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            System.out.println("Сообщение: " + message + " | Пропущено: " + isFiltered);
        }
    }
}