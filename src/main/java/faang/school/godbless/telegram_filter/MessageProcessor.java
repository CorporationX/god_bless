package faang.school.godbless.telegram_filter;

import java.util.List;

public class MessageProcessor {
    public static boolean processMessage(String message, List<MessageFilter> filters) {
        return filters.stream().allMatch(filter -> filter.filter(message));
    }
}
