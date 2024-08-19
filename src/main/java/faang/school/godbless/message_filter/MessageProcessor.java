package faang.school.godbless.message_filter;

import java.util.List;

public class MessageProcessor {

    public boolean processMessage(String message, List<MessageFilter> filters) {
        return filters.stream().allMatch(f -> f.filter(message));
    }
}
