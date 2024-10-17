package school.faang.BJS2_34595_FilteringSpam;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> messageFilters) {
        return messageFilters.stream()
                .allMatch(filter -> filter.filter(message));
    }
}
