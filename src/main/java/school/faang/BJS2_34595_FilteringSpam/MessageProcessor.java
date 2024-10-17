package school.faang.BJS2_34595_FilteringSpam;

import java.util.List;
import java.util.Arrays;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> messageFilters) {
        return messageFilters.stream()
                .allMatch(filter -> filter.filter(message));
    }

    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

        MessageFilter spamFilter = message -> !message.toLowerCase().contains("спам");
        MessageFilter lengthFilter = message -> message.length() > 10;
        MessageFilter emojiFilter = message -> !message.contains("😀");

        List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter, emojiFilter);

        String[] messages = {
                "Привет!", "Это спам!", "Как дела? 😀",
                "Длинное сообщение без спама и эмодзи", "ЭТо точно не спаm!!!!!!"
        };

        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            System.out.println("Сообщение: " + message + " | Пропущено: " + isFiltered);
        }
    }
}
