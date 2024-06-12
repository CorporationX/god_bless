package faang.school.godbless.BJS2_9973;

import java.util.List;

public class MessageProcessor {

    public boolean processMessage(String message, List<MessageFilter> messageFilters) {
        // если хотя бы один ильтр применен, то озвращаем true
        return messageFilters.stream()
                .anyMatch(filter -> filter.filter(message));
    }
}
