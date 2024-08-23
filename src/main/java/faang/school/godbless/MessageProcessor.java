package faang.school.godbless;

import java.util.Arrays;
import java.util.List;

interface MessageFilter {
    boolean filter(String message);
}

class MessageProcessor {

    boolean processMessage(String message, List<MessageFilter> filters) {
        for (MessageFilter messageFilter : filters) {
            if (!messageFilter.filter(message)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

        MessageFilter spamFilter = message -> !message.toLowerCase().contains("span");
        MessageFilter lengthFilter = message -> message.length() > 10;
        MessageFilter emojiFilter = message -> !message.contains("😀");
        MessageFilter banFilter = message -> !message.toLowerCase().contains("ban");

        List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter, emojiFilter, banFilter);
        String[] messages = {"Hello!", "This span!", "How are you? 😀", "Long message without spam and emoji", "Message message ban ", "Just text, just text."};

        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            System.out.println("Сообщение: " + message + " | Пропущено: " + isFiltered);
        }
    }
}
