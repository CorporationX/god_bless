package faang.school.godbless.spam_filter;

import lombok.NonNull;

import java.util.Arrays;
import java.util.List;

public class MessageProcessor {

    public boolean processMessage(@NonNull String message, @NonNull List<MessageFilter> filters) {
        for (MessageFilter messageFilter : filters) {
            if (!messageFilter.filter(message)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

        MessageFilter spamFilter = message -> !message.toLowerCase().contains("спам");
        MessageFilter lengthFilter = message -> message.length() > 10;
        MessageFilter emojiFilter = message -> !message.contains("?");
        MessageFilter blankFilter = message -> !message.isBlank();
        MessageFilter pointFilter = message -> message.endsWith(".");

        List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter, emojiFilter, blankFilter, pointFilter);

        String[] messages = {"Привет!", "Это спам!", "Как дела?", "Длинное сообщение без спама и эмодзи.", "   "};

        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            System.out.println("Сообщение: " + message + " | Пропущено: " + isFiltered);
        }
    }
}
