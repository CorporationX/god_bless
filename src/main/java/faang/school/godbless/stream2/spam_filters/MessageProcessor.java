package faang.school.godbless.stream2.spam_filters;

import java.util.ArrayList;
import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> messageFilters) {
        List<Boolean> filtered = new ArrayList<>();
        messageFilters.forEach(filter -> {
            filtered.add(filter.filter(message));
        });
        return !filtered.contains(false);
    }
}
