package school.faang.spamfilter;

import java.util.List;

public class MessageProcessor {

    public boolean processMessage(String message, List<MessageFilter> filters) {
        for (MessageFilter filter : filters) {
            if (!filter.filter(message)) {
                return false; // Сообщение не прошло фильтр
            }
        }
        return true; // Сообщение прошло все фильтры
    }

}
