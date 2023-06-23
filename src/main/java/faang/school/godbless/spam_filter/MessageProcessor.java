package faang.school.godbless.spam_filter;

import java.util.List;

public class MessageProcessor {
    public static boolean processMessage(String message, List<MessageFilter> filters) {
        return filters.stream().allMatch(messageFilter -> messageFilter.filter(message));
    }
}