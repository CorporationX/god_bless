package faang.school.godbless.r_edzie.spam;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> messageFilters) {
        boolean isFiltered = false;

        for (MessageFilter messageFilter : messageFilters) {
            if (!messageFilter.filter(message)) {
                isFiltered = true;
                break;
            }
        }

        return isFiltered;
    }
}
