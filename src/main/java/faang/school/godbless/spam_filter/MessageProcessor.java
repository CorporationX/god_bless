package faang.school.godbless.spam_filter;

import java.util.List;

public class MessageProcessor {
    public static boolean processMessage(String message, List<MessageFilter> filters) {
        for (MessageFilter messageFilter : filters) {
            return messageFilter.filter(message);
        }
        return false;
    }
}
