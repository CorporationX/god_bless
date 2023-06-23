package faang.school.godbless.filtering_spam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> filters) {
        for (MessageFilter anotherFilter : filters) {
            if (!anotherFilter.filter(message)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

        MessageFilter spamFilter = message -> !message.toLowerCase().contains("spam");
        MessageFilter lengthFilter = message -> message.length() > 10;

        List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter);

        String[] messages = {"Hello", "spam!", "Long message without emoji"};

        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            System.out.println("Сообщение: " + message + " | Пропущено: " + isFiltered);
        }
    }
}
