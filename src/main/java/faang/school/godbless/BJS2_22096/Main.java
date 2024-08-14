package faang.school.godbless.BJS2_22096;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

// Создание фильтров
        MessageFilter spamFilter = message -> message.toLowerCase().contains("spam");
        MessageFilter lengthFilter = message -> message.length() > 50;
//        MessageFilter emojiFilter = message -> !message.contains(""); На данный фильтр идеа ругается, если даже он закомментирован(ругается конкретно на символ смайла)

        List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter);

// Обработка сообщений
        String[] messages = {"hi", "Это spam!", "Как дела?", "Длинное сообщение без спама и эмодзи"};

        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            System.out.println("Сообщение: " + message + " | Пропущено: " + isFiltered);
        }
    }
}
