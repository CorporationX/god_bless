package faang.school.godbless.func.spam;

import java.util.List;

public record MessageProcessor() {

    public boolean processMessage(String message, List<MessageFilter> filters) {
        return filters.stream().allMatch(messageFilter -> messageFilter.filter(message));
    }
}
