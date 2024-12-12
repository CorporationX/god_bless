package school.faang.sprint_2.task_46295;

import java.util.List;

public class MessageProcessor {

    public boolean processMessage(String message, List<MessageFilter> filters) {
        return filters.stream()
                .anyMatch(filter -> !filter.filter(message));
    }
}
