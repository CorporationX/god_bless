package school.faang.bjs270199;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static final String[] MESSAGES = {
            "Привет!",
            "Это спам!",
            "Как дела? 😀",
            "Длинное сообщение без спама и эмодзи"
    };

    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

        List<MessageFilter> filters = createFilters();

        for (String message : MESSAGES) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            System.out.println("Сообщение: " + message + " | Прошло все фильтры: " + isFiltered);
        }
    }

    private static List<MessageFilter> createFilters() {
        MessageFilter spamFilter = message -> !message.toLowerCase().contains("спам");
        MessageFilter lengthFilter = message -> message.length() > 10;
        MessageFilter emojiFilter = message -> !message.contains("😀");

        return Arrays.asList(spamFilter, lengthFilter, emojiFilter);
    }
}