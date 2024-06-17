package faang.school.godbless.lambda.messagefilter;

import lombok.Data;
import java.util.List;

@Data
public class MessageProcessor {

    public boolean processMessage(String message, List<MessageFilter> messageFilters) {
        return messageFilters.stream().anyMatch(messageFilter -> messageFilter.filter(message));
    }
}
