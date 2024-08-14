package faang.school.godbless.BJS2_22094;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> messageFilterList) {
        for (MessageFilter messageFilter : messageFilterList) {
            if (!messageFilter.filter(message)) {
                return false;
            }
        }
        return true;
    }
}
