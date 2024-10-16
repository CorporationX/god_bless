package spamFiltering;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> messageFilters) {
        for (MessageFilter messageFilter : messageFilters) {
            if (messageFilter.filter(message)) {
                return false;
            }
        }
        return true;
    }
}
