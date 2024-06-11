package faang.school.godbless.BJS2_10274;

import java.util.List;


public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> messageFilters) {
        if (message == null || message.trim().isEmpty() || messageFilters == null) throw new IllegalArgumentException();
        boolean result = false;
        for (MessageFilter messageFilter : messageFilters) {
            if (!messageFilter.filter(message)) {
                break;
            } else result = true;
        }
        return result;
    }
}
