package faang.school.godbless.BJS2_9966;

import java.util.List;

public class MessageProcessor {

    public boolean processMessage(String message, List<MessageFilter> messageFilters) {
        boolean isFiltered = false;
        for (MessageFilter messageFilter : messageFilters) {
            if (messageFilter.filter(message)) {
                isFiltered = true;
            }
        }
        return isFiltered;
    }
}
