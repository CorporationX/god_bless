package school.faang.bjs2_71472;

import java.util.List;

public class MessageProcessor {

    public boolean processMessage(String message, List<MessageFilter> messageFilters) {
        if (message == null) {
            return false;
        }

        if (messageFilters == null || messageFilters.isEmpty()) {
            return true;
        }

        return messageFilters.stream().allMatch(messageFilter -> messageFilter.filter(message));
    }
}
