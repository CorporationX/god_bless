package school.faang.bjs270199;

import java.util.List;
import java.util.Objects;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> filters) {
        Objects.requireNonNull(message, "Message cannot be null");
        Objects.requireNonNull(filters, "Filters list cannot be null");

        for (MessageFilter filter : filters) {
            if (!filter.filter(message)) {
                return false;
            }
        }
        return true;
    }
}