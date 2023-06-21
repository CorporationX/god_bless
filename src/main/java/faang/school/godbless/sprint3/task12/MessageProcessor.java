package faang.school.godbless.sprint3.task12;

import java.util.List;

public class MessageProcessor {

    public boolean processMessage(String message, List<MessageFilter> messageFilters) {
        if (message.isBlank()) {
            throw new IllegalArgumentException("Message не может быть пустым!");
        }
        if (messageFilters == null) {
            throw new IllegalArgumentException("список MessageFilter не может быть null!");
        }

        for (MessageFilter filter : messageFilters) {
            if (filter == null) {
                throw new NullPointerException("MessageFilter не может быть null!");
            }
            if (!filter.filter(message)) {
                return false;
            }
        }
        return true;
    }
}
