package faang.school.godbless.spamfilter;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> filters) {
        for (MessageFilter item :filters) {
            if(!item.filter(message)) {
                return false;
            }
        }
        return true;
    }
}
