package school.faang.sprint_2.task_46728;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String string, List<MessageFilter> filters) {
        return filters.stream()
                .allMatch(f -> f.filter(string));
    }
}
