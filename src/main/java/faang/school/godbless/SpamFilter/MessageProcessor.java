package faang.school.godbless.SpamFilter;

import java.util.Arrays;
import java.util.List;

public class MessageProcessor {

    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

        MessageFilter spamFilter = message -> !message.toLowerCase().contains("спам");
        MessageFilter lengthFilter = message -> message.length() > 10;
        MessageFilter emojiFilter = message -> !message.contains("😀");

        List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter, emojiFilter);

        String[] messages = {"Привет!", "Это спам!", "Как дела? 😀", "Длинное сообщение без эмодзи"};

        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            System.out.println("Сообщение: " + message + " | Пропущено: " + isFiltered);
        }
    }

    public boolean processMessage(String message, List<MessageFilter> filters) {

        for (MessageFilter filter : filters) {
            if (!filter.filter(message)) {
                return false;
            }
        }
        return true;
    }
}
