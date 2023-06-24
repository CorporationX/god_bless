package faang.school.godbless.telegram;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> messageFilters) {
        return messageFilters.stream()
            .findFirst()
            .orElseThrow(IllegalArgumentException::new)
            .filter(message);
    }
}
