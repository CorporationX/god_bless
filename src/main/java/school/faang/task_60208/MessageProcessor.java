package school.faang.task_60208;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String string, List<MessageFilter> filters) {
        return filters.stream()
                .allMatch(f -> f.filter(string));
    }
}
