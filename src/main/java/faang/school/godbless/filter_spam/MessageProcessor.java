package faang.school.godbless.filter_spam;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> filters) {
        for (MessageFilter oneFilter : filters) {
            if (oneFilter.filter(message)) {
                return true;
            }
        }
        return false;
    }
}
