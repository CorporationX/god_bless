package faang.school.godbless.spamFilter;

import java.util.List;

public class MessageProcessor {

    public boolean processMessage(String message, List<MessageFilter> filters){
//        Найденое решение
//        return filters.stream().allMatch(messageFilter -> messageFilter.filter(message));
        for (MessageFilter filter: filters) {
            if(!filter.filter(message)){
                return false;
            }
        }
        return true;

    }
}
