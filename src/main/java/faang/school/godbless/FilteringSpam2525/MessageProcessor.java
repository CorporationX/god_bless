package faang.school.godbless.FilteringSpam2525;

import java.util.List;

public class MessageProcessor {

    public boolean processMessage(String message, List<MessageFilter> filterList) {
        boolean isOkay = true;
        for (MessageFilter filter : filterList) {
            if (filter.filter(message)) {
                isOkay = false;
            }
        }
        return isOkay;
    }
}
