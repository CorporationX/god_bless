package school.faang.m1s2.bjs2_34609_spamFilter;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> filters) {
        return filters.stream()
                .allMatch(f -> f.filter(message));
    }
}
