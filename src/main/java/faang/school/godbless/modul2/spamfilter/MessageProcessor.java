package faang.school.godbless.modul2.spamfilter;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> filters) {
        return filters.stream().allMatch(filter -> filter.filter(message));
    }
}
