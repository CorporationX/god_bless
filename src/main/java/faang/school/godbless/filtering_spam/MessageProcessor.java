package faang.school.godbless.filtering_spam;

import java.util.List;

public class MessageProcessor {

    public boolean processorMessage(String message, List<MessageFilter> filters) {
        if (message.isEmpty() && message.isBlank()) {
            throw new IllegalArgumentException("is blank message");
        }

        for (MessageFilter filter : filters) {
            if (filter.filter(message)) {
                return true;
            }
        }
        return false;
    }
}
