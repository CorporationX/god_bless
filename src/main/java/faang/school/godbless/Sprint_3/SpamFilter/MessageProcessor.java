package faang.school.godbless.Sprint_3.SpamFilter;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> messageFilterList) {
        for (MessageFilter messageFilter : messageFilterList) {
            if (!messageFilter.filter(message)) return false;
        }
        return true;
    }
}
