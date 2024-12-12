package school.faang.sprint_2.task_bjs246282;

import java.util.Set;

public class MessageProcessor {
    public boolean processMessage(String message, Set<MessageFilter> messageFilters) {
        if (messageFilters == null) {
            return true;
        }
        return messageFilters.stream()
                .allMatch(messageFilter -> messageFilter.filter(message));
    }
}
