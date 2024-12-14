package school.faang.bjs246315;

import java.util.List;

public class MessageProcessor {

    public boolean processMessage(String message, List<MessageFilter> messageFilters) {
        for (MessageFilter messageFilter : messageFilters) {
            messageFilter.filter(message);
            if (!messageFilter.filter(message)) {
                return false;
            }
        }
        return true;
    }
}