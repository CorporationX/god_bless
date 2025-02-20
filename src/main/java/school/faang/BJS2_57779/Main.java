package school.faang.BJS2_57779;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

        List<MessageFilter> filters = Arrays.asList(Filters.lengthFilter(),
                Filters.spamFilter(), Filters.emojiFilter());

        String[] messages = {"Привет!", "Это спам!", "Как дела? 😀", "Длинное сообщение без спама и эмодзи"};

        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            System.out.printf("Сообщение: %s | Прошло все фильтры: %b\n", message, isFiltered);
        }
    }
}
