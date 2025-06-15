package school.faang.bjs2_80592;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> filters) {
        for (MessageFilter filter : filters) {
            if (!filter.filter(message)) {
                return false;
            }
        }
        return true;
    }
}
