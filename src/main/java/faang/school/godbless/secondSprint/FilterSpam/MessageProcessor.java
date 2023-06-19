package faang.school.godbless.secondSprint.FilterSpam;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> filters) {
        return filters.stream().noneMatch(messageFilter -> messageFilter.filter(message));
    }
}
