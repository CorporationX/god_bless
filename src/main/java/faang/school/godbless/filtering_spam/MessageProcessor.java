package faang.school.godbless.filtering_spam;

import java.util.List;

public class MessageProcessor {
    public boolean processorMessage(String message, List<MessageFilter> filters) {
        if (message.isEmpty() && message.isBlank()) {
            throw new IllegalStateException(" is blank message");
        }

        for (MessageFilter filter : filters) {
            if (filter.filters(message)) {
                return true;
            }
        }
        return false;
    }
}
