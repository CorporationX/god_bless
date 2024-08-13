package spam;

import lombok.NonNull;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(@NonNull String message, @NonNull List<MessageFilter<String>> filters) {
        for(MessageFilter<String> filter : filters) {
            if (filter.filter(message)) {
                return true;
            }
        }
        return false;
    }
}
