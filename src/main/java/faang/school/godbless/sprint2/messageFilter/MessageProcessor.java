package faang.school.godbless.sprint2.messageFilter;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String messages, List<MessageFilter> messageFilters) {
        return messageFilters.stream().allMatch(messageFilter -> messageFilter.filter(messages));
    }
}
