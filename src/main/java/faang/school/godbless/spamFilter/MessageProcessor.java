package faang.school.godbless.spamFilter;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> messageFilterList) {
        for (MessageFilter filter : messageFilterList) {
            if (filter.filter(message)) {
                return true;
            }
        }
        return false;
    }
}
