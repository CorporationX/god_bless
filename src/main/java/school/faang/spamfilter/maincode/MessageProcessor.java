package school.faang.spamfilter.maincode;

import java.util.List;

public class MessageProcessor {
    public boolean messageFilter(String message, List<MessageFilter> filters) {
        for (MessageFilter messageFilter : filters) {
            if (!messageFilter.filter(message)) {
                return false;
            }
        }
        return true;
    }
}