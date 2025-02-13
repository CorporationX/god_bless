package school.faang.task57760.service;


import java.util.List;

public class MessageProcessor {
    boolean processMessage(String message, List<MessageFilter> filters) {
        for (MessageFilter messageFilter : filters) {
            messageFilter.filter(message)
        }
        return false;
    }

    MessageFilter spamFilter = (message -> !message.toLowerCase().contains("спам"));
    MessageFilter lengthFilter = (message -> message.length() > 10);
    MessageFilter emojiFilter = (message -> {
        char flag = ((char) 0x2691);
        return !message.contains(String.valueOf(flag));
    });
}