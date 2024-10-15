package school.faang.BJS2_34592;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

        // Фильтры
        MessageFilter spamFilter = message -> !message.toLowerCase().contains("спам");
        MessageFilter lengthFilter = message -> message.length() > 10;
        MessageFilter emojiFilter = message -> !message.contains("улыбка");

        // Список фильтров
        List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter, emojiFilter);

        // Входящие сообщения
        String[] messages = {"Привет!", "Это спам!", "Как дела? улыбка", "Длинное сообщение без спама и эмодзи"};

        // Обработка сообщений
        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            System.out.println("Сообщение: \"" + message + "\" | Пропущено: " + isFiltered);
        }
    }
}
