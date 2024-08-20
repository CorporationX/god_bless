package BJS2_22136_SpamFilter;

import java.util.List;

public class MessageProcessor {
    public static boolean processMessage(String message, List<MessageFilter> filterList) {
        if (message == null) {
            throw new IllegalArgumentException("Message can't be null!");
        }
        for (MessageFilter messageFilter : filterList) {
            if (!messageFilter.filter(message)) {
                return false;
            }
        }
        return true;
    }
}
