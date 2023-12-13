package faang.school.godbless.BJS2_795;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> messageFilters) {
        return messageFilters.stream().allMatch(messageFilter -> messageFilter.filter(message));
    }
}