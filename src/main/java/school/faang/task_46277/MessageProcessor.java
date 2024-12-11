package school.faang.task_46277;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String str, List<MessageFilter> filters) {
        return filters.stream()
                .allMatch(f -> f.filter(str));
    }
}
