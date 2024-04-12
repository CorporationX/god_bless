package faang.school.godbless.spam;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> filters) {
        return filters.stream().allMatch(messageFilter -> messageFilter.filter(message));
    }
}
