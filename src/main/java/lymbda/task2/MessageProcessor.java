package lymbda.task2;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> messageFilters) {
        for (MessageFilter filter : messageFilters) {
            if (!filter.filter(message)) {
                return false;
            }
        }
        return true;
    }
}
