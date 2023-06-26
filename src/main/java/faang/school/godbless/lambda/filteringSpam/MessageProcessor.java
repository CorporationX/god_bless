package faang.school.godbless.lambda.filteringSpam;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> messageFilterList) {
        if (message == null || message.isEmpty()) {
            throw new IllegalArgumentException("Сообщение пусто!");
        }
        if (messageFilterList == null) {
            throw new IllegalArgumentException("Обработчики сообщения равны null!");
        }

        for (MessageFilter messageFilter: messageFilterList) {
            if (!messageFilter.filter(message)){
                return false;
            }
        }

        return true;
    }
}
