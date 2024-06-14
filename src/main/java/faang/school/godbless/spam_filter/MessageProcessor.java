package faang.school.godbless.spam_filter;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> messageFilters) {
        if(message == null || messageFilters == null){
            throw new IllegalArgumentException("Message and messageFilters cannot be null");
        }
        boolean result = true;
        for (MessageFilter messageFilter : messageFilters){
            result &= messageFilter.filter(message);
        }
        return result;
    }
}
