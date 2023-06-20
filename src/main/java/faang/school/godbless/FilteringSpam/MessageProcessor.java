package faang.school.godbless.FilteringSpam;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> filters) {
        for (MessageFilter filter : filters) {
            if (!filter.filter(message)) {
                return true;
            }
        }
        return false;
    }
}
