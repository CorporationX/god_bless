package faang.school.godbless;

import lombok.NonNull;

import java.util.List;

public class MessageProcessor {

    @NonNull
    public boolean processMessage(String message, List<MessageFilter> messageProcessing) {
        boolean filtered = true;

        for (MessageFilter messageFilter : messageProcessing) {
            if (!messageFilter.filter(message)) {
                filtered = false;
            }
        }
        return filtered;
    }
}
