package faang.school.godbless;

import java.util.Arrays;
import java.util.List;

public class Filter {
    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

// Создание фильтров
        MessageFilter spamFilter = message -> !message.toLowerCase().contains("spam");
        MessageFilter lengthFilter = message -> message.length() > 10;
        MessageFilter emojiFilter = message -> !message.contains("^");

        List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter, emojiFilter);

// Обработка сообщений
        String[] messages = {"Hello!", "This spam!", "How are your ^", "Long message without emoji"};

        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            System.out.println("Сообщение: " + message + " | Пропущено: " + isFiltered);
        }
    }
}
