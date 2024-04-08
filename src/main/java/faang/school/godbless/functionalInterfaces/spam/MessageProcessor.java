package faang.school.godbless.functionalInterfaces.spam;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class MessageProcessor {
    public boolean processMessage(String  message, List<MessageFilter> filters) {
        AtomicBoolean isFiltered = new AtomicBoolean(true);

        filters.forEach(currentFilter -> {
            if(!currentFilter.filter(message)) {
                isFiltered.set(false);
            }
        });

        return isFiltered.get();
    }
}
