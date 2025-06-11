package school.faang.spam;

import java.util.Arrays;

/**
 * @author Danil Pudovkin
 * @since 11.06.2025
 */
public class Main {

    public static void main(String[] args) {
        var messageProcessor = new MessageProcessor();

        var spamFilter = (MessageFilter) message -> !message.toLowerCase().contains("спам");
        var lengthFilter = (MessageFilter) message -> message.length() > 10;
        var emojiFilter = (MessageFilter) message -> !message.contains("😀");

        var filters = Arrays.asList(spamFilter, lengthFilter, emojiFilter);

        String[] messages = {"Привет!", "Это спам!", "Как дела? 😀", "Длинное сообщение без спама и эмодзи"};

        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            System.out.println("Сообщение: " + message + " | Прошло все фильтры: " + isFiltered);
        }
    }
}
