package faang.school.godbless;

import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String... args) {
        MessageProcessor messageProcessor = new MessageProcessor();

        MessageFilter spamFilter = message -> !message.toLowerCase().contains("спам".toLowerCase());
        MessageFilter lengthFilter = message -> message.length() > 10;
        MessageFilter emojiFilter = message -> !message.contains("смайл");

        List<MessageFilter> filters = List.of(spamFilter, lengthFilter, emojiFilter);

        String[] messages = {"Привет!", "Это спам!", "Как дела? смайл", "Длинное сообщение без спама и эмодзи"};

        for (String message : messages) {
            List<Boolean> isFiltered = messageProcessor.processMassage(message, filters);
            System.out.println("Сообщение: " + message + " | Пропущено: " + isFiltered);
//        }
        }
    }
}
