package faang.school.godbless.filtering_spam;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {

        MessageProcessor messageProcessor = new MessageProcessor();

        // Создание фильтров
        MessageFilter spamFilter = message -> !message.toLowerCase().contains("spam");
        MessageFilter lengthFilter = message -> message.length() > 10;
        MessageFilter emojiFilter = message -> !message.contains("😀");

        List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter, emojiFilter);

        // Обработка сообщений
        String[] messages = {"Hello!", "This is spam!", "How are you? 😀", "Long message without spam and emoji"};

        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            System.out.println("Message: " + message + " | Missed: " + isFiltered);
        }
    }
}
