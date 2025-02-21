package school.faang.spamfilter;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class MessageProcessor {
    public Boolean processMessage(@NonNull String message, List<MessageFilter> filters) {
        checkMessage(message);
        for (MessageFilter filter : filters) {
            if (!filter.filter(message)) {
                return false;
            }
        }
        return true;
    }

    private void checkMessage(String message) {
        if (message == null) {
            log.error("Message is null");
            throw new RuntimeException("Message is null");
        }
        if (message.isEmpty()) {
            log.error("Message is empty");
            throw new IllegalArgumentException("Message is empty");
        }
    }
}