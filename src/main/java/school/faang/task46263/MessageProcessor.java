package school.faang.task46263;

import java.util.List;

public class MessageProcessor {
    public void processMessage(String message, List<MessageFilter> messageFilters) {
        if (message == null || message.isBlank()) {
            throw new IllegalArgumentException("Message cannot be null or blank");
        }
        if (messageFilters == null) {
            throw new IllegalArgumentException("Message filters cannot be null");
        }

        for (MessageFilter messageFilter : messageFilters) {
            if (messageFilter == null) {
                continue;
            }
            if (!messageFilter.filter(message)) {
                throw new IllegalArgumentException("the message: (" + message + ") did not pass all filters");
            }
        }

        System.out.println("Message filters: " + message);
    }
}
