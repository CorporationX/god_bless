package school.faang.spam;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> filters) {
        for (MessageFilter someFilter : filters) {
            if (!someFilter.filter(message)) {
                return false;
            }
        }
        return true;
    }
}
