package Filtering_spam;

import java.util.ArrayList;
import java.util.List;

public class MessageProcessor {
    public List<Boolean> processMessage(String message, List<MessageFilter> filters) {
        List<Boolean> isFilteredMessage = new ArrayList<>();
        for (MessageFilter filter : filters) {
            boolean filterResult = filter.filter(message);
            if (!filterResult) {
                isFilteredMessage.add(false);
            } else {
                isFilteredMessage.add(true);
            }
        }
        return isFilteredMessage;
    }

}
