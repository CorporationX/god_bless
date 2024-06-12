package faang.school.godbless.lambda;

import lombok.Data;
import java.util.List;

@Data
public class MessageProcessor {

    public boolean processMessage(String message, List<MessageFilter> messageFilters) {
        return messageFilters.stream().anyMatch(messageFilter -> Boolean.TRUE.equals(messageFilter.filter(message)));
    }
}
