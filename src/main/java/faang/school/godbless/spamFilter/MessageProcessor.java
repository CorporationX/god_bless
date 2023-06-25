package faang.school.godbless.spamFilter;

import java.util.List;

public class MessageProcessor {
    boolean processMessage(String message, List<MessageFilter> filters) {
        for (MessageFilter filter : filters) {
            if (filter.filter(message)) {
                return true;
            }
        }
        return false;
    }
}
