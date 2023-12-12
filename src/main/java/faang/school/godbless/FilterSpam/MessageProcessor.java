package faang.school.godbless.FilterSpam;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> filters) {
        for (MessageFilter fil : filters) {
            if (!fil.filter(message)) {
                return false;
            }
        }
        return true;
    }
}
