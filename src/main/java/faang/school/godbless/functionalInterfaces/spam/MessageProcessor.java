package faang.school.godbless.functionalInterfaces.spam;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String  message, List<MessageFilter> filters) {
        return filters.stream().allMatch(currentFilter -> currentFilter.filter(message));
    }
}
