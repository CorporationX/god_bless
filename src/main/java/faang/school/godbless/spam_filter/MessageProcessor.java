package faang.school.godbless.spam_filter;

import java.util.List;

@FunctionalInterface
interface MessageFilter {
    boolean filter(String message);
}

public class MessageProcessor {

    public boolean processMessage(String message, List<MessageFilter> filters) {
        for (MessageFilter filter : filters) {
            if (!filter.filter(message)) {
                return false;
            }
        }
        return true;
    }
}


