package faang.school.godbless.sprint3.filterSpam.classes;

import faang.school.godbless.sprint3.filterSpam.interfaces.MessageFilter;

import java.util.List;

public class MessageProcessor {
    public static final String MESSAGE_IS_NULL_OR_EMPTY = "Message is null or empty";
    public static final String FILTERS_LIST_IS_NULL_OR_EMPTY = "Filters is null or empty";

    public boolean processMessage(String message, List<MessageFilter> filters) {
        if (message == null || message.isEmpty()) {
            throw new IllegalArgumentException(MESSAGE_IS_NULL_OR_EMPTY);
        }
        if (filters == null || filters.size() < 1) {
            throw new IllegalArgumentException(FILTERS_LIST_IS_NULL_OR_EMPTY);
        }
        boolean result = false;
        for (MessageFilter filter : filters) {
            result = filter.filter(message);
            if (!result) {
                break;
            }
        }
        return result;
    }
}
