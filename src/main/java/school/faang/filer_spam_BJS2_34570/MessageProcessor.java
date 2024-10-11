package school.faang.filer_spam_BJS2_34570;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> filters) {
        return filters.stream()
                .allMatch(messageFilter -> messageFilter.filter(message));
    }
}
