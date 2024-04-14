package faang.school.godbless.BJS2_5384;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> filters) {
        for (MessageFilter currentFilter : filters) {
            if (!currentFilter.filter(message)) {
                return false;
            }
        }
        return true;
    }
}
