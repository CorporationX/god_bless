package faang.school.godbless;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String... args) {
        MessageProcessor messageProcessor = new MessageProcessor();

        MessageFilter spamFilter = message -> !message.toLowerCase().contains("spam"); // true - не содержит спам
        MessageFilter lengthFilter = message -> message.length() > 10; // true - длина сообщений > 10
        MessageFilter emojiFilter = message -> !message.contains("123"); // true - не содержит "123"

        List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter, emojiFilter);

        String[] messages = {"Hello!", "It's spam!", "How are you? 123", "Long message without spam and emoji"};

        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            System.out.println("Сообщение: " + message + " | Пропущено: " + isFiltered);
        }
    }
}
