package faang.school.godbless.lambda.spam;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> messageFilterList) {
        boolean isFiltered = true;
        for (MessageFilter messageFilter : messageFilterList) {
            boolean filterResult = messageFilter.filter(message);
            if (filterResult == false) {
                isFiltered = false;
                break;
            }
        }
        return isFiltered;
    }
}