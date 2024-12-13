package school.faang.task_46294;

import lombok.NonNull;

import java.util.List;
import java.util.Objects;

public class MessageProcessor {
    public boolean processMessage(@NonNull String message, @NonNull List<MessageFilter> filters) {
        return filters.stream()
                .filter(Objects::nonNull)
                .allMatch((filter) -> filter.filter(message));
    }
}
