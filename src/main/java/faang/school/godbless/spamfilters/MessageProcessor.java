package faang.school.godbless.spamfilters;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> filters) {
        return filters.stream()
                .map(filter -> filter.filter(message))
                .filter(Boolean.TRUE::equals)
                .findFirst()
                .orElse(Boolean.FALSE);
    }
}
