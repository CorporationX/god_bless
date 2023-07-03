package faang.school.godbless.filtering_spam;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String inputMessage, List<MessageFilter> handlers) {
        for (MessageFilter handler : handlers) {
            if (!handler.filter(inputMessage)) {
                return false;
            }
        }
        return true;
    }
}
