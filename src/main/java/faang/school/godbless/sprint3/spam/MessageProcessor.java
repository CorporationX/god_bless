package faang.school.godbless.sprint3.spam;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> filters) {
        return !filters.stream()
                .map(f -> f.filter(message))
                .toList()
                .contains(false);
    }
}
