package faang.school.godbless;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String... args) {
        MessageProcessor messageProcessor = new MessageProcessor();

// Создание фильтров
        MessageFilter spamFilter = message -> !message.toLowerCase().contains("спам");
        MessageFilter lengthFilter = message -> message.length() > 10;
        MessageFilter emojiFilter = message -> !message.contains("казино");

        List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter, emojiFilter);

// Обработка сообщений
        String[] messages = {"Привет!", "Это спам!", "Как дела? Играй в казино", "Длинное сообщение без спама и эмодзи"};

        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            System.out.println("Сообщение: " + message + " | Пропущено: " + isFiltered);
        }
    }
}
