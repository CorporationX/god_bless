package faang.school.godbless.BJS2_22171;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> messageFilters) {
        AtomicBoolean resultOfFilter = new AtomicBoolean(false);

        messageFilters.forEach(filter -> {
            if(!filter.filter(message)) {
                resultOfFilter.set(true);
            }
        });

        return resultOfFilter.get();
    }
}
