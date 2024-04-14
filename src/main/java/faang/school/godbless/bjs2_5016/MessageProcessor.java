package faang.school.godbless.bjs2_5016;

import java.util.List;

public class MessageProcessor {

    public boolean processMessage(String message, List<MessageFilter> filters) {

        return filters.stream()
                .filter(currentFilter -> currentFilter.filter(message))
                .toList().size() == filters.size();
    }
}
