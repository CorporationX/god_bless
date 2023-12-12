package faang.school.godbless.filter_spam;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> filters){
    boolean isFiltered=true;
    for (MessageFilter filter : filters){
        if (filter.apply(message) == false){
            isFiltered=false;
            break;
        }

    }
    return isFiltered;
    }
}
