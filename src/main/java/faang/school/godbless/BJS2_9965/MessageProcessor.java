package faang.school.godbless.BJS2_9965;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> filters) {
        boolean applied = false;
        for (MessageFilter filter : filters) {
            applied = filter.filter(message);
            if (applied) {
                break;
            }
        }
        return applied;
    }
}
