package faang.school.godbless.BJS2_22171;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> messageFilters) {
        for(var filter : messageFilters) {
            if(!filter.filter(message)) {
                return true;
            }
        }
        return false;
    }
}
