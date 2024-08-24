package faang.school.functionalinterfacesandlambdas.filterspam;

import java.util.List;

public class MessageProcessor {

    public boolean processMessage(String message, List<MessageFilter> messageFilters) {
        if (message == null && message.isBlank()) {
            throw new IllegalArgumentException("Message cannot be null or blank.");
        }
        if (messageFilters == null && messageFilters.isEmpty()) {
            throw new IllegalArgumentException("Message filters cannot be null or empty.");
        }
        for (MessageFilter messageFilter : messageFilters) {
            if (!messageFilter.filter(message)) {
                return false;  // Return false if any filter does not pass
            }
        }
        return true;
    }
}
