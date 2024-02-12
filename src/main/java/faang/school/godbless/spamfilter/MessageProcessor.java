package faang.school.godbless.spamfilter;

import java.util.List;

public class MessageProcessor {

    public boolean processMessage(String message, List<MessageFilter> filters) {
        for (var messageFilter : filters) {
            if (!messageFilter.filter(message)) {
                return false;
            }
        }
        return true;
    }
}
