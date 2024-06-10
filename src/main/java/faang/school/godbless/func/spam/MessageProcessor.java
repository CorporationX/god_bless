package faang.school.godbless.func.spam;

import java.util.List;

public record MessageProcessor() {

    public boolean processMessage(String message, List<MessageFilter> filters) {
        if (message == null || filters == null) {
            throw new IllegalArgumentException("Filters and message cannot be null for processing");
        }
        return filters.stream().allMatch(messageFilter -> messageFilter.filter(message));
    }
}
