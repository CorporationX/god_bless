package faang.school.godbless.filter.spam;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> filterList) {
        for (MessageFilter appFilter : filterList) {
            if (appFilter.filter(message)) {
                return false;
            }
        }
        return true;
    }
}
