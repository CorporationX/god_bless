package faang.school.godbless;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> filters) {
        return filters.stream().allMatch(filterMessage -> filterMessage.filter(message));
    }
}
