package faang.school.godbless;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> filters) {
        boolean result = true;
        for (MessageFilter messageFilter : filters) {
            result &= messageFilter.filter(message);
        }
        return result;
    }
}
