package faang.school.godbless.filter_spam;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> filters) {

        for (MessageFilter filter : filters) {
            if (!filter.apply(message)) {
                return false;
            }
        }
        return true;
    }
}
