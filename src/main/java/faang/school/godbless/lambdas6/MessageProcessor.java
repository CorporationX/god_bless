package faang.school.godbless.lambdas6;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> filters) {
        int countFilters = 0;
        for (MessageFilter filter : filters) {
            if (filter.filter(message)) {
                countFilters++;
            }
        }
        return countFilters == filters.size();
    }
}
