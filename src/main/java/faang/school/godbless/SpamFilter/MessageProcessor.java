package faang.school.godbless.SpamFilter;

import lombok.NonNull;

import java.util.List;

public class MessageProcessor <T>{
    public boolean processMessage(@NonNull T message, @NonNull List<MessageFilter> filters) {
        for (MessageFilter messageFilter : filters) {
            if (messageFilter.filter(message)) {
                return true;
            }
        }
        return false;
    }
}
