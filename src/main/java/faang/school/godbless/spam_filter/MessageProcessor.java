package faang.school.godbless.spam_filter;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> messageFilters) {
        boolean result = false;
        for (MessageFilter messageFilter : messageFilters) {
            result |= messageFilter.filter(message);
        }
        return result;
    }
}
