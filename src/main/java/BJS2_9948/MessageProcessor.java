package BJS2_9948;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> messageFilters) {
        return messageFilters.stream()
                .allMatch(messageFilter -> messageFilter.filter(message));
    }
}