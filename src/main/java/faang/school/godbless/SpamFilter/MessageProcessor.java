package faang.school.godbless.SpamFilter;

import java.util.List;

public class MessageProcessor {
    boolean processMessage(String message, List<MessageFilter> filters) {
        return filters.stream().anyMatch(filter -> !filter.filter(message));
    }
}
