package faang.school.godbless.filter_spam;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String incomingMessage, List<MessageFilter> filters) {
        if (incomingMessage == null || incomingMessage.isEmpty()) {
            throw new IllegalArgumentException("Входящее сообщение не может быть null или пустым");
        }

        if (filters == null || filters.isEmpty()) {
            throw new IllegalArgumentException("Список фильтров не может быть null или пустым");
        }

        for (MessageFilter messageFilter : filters) {
            if (messageFilter.filter(incomingMessage)) {
                return false;
            }
        }
        return true;
    }
}

