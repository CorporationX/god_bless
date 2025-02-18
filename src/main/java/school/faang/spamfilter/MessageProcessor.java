package school.faang.spamfilter;

import java.util.List;

public class MessageProcessor {

    public boolean processMessage(String message, List<MessageFilter> filters) {
        if (message == null || filters == null) {
            System.out.println("Ошибка: входные параметры не могут быть null.");
            return false;
        }

        for (MessageFilter filter : filters) {
            if (!filter.filter(message)) {
                return false;
            }
        }
        return true;
    }

}