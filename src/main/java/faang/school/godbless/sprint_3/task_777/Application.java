package faang.school.godbless.sprint_3.task_777;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

// Создание фильтров
        MessageFilter spamFilter = message -> !message.toLowerCase().contains("спам");
        MessageFilter lengthFilter = message -> message.length() > 10;
        MessageFilter hardLanguageFilter = message -> !message.contains("fuck");

        List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter, hardLanguageFilter);

// Обработка сообщений
        String[] messages = {"Привет!", "Это спам!", "Как дела? ", "Длинное сообщение без спама и эмодзи"};

        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            System.out.println("Сообщение: " + message + " | Пропущено: " + isFiltered);
        }
    }
}
