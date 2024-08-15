package spam;

import lombok.NonNull;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(@NonNull String message, @NonNull List<MessageFilter<String>> filters) {
        boolean result = true;
        for(MessageFilter<String> filter : filters) {
            result = result && filter.filter(message);
            if (!result) {
                break;
            }
        }
        return result;
    }
}
