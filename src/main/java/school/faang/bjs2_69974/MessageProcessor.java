package school.faang.bjs2_69974;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> filters) {
        return filters.stream()
                .allMatch(filter -> filter.filter(message));
    }
}