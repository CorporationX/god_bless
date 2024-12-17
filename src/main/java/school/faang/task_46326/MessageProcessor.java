package school.faang.task_46326;

import java.util.List;

public class MessageProcessor {
    public boolean processMassage(String message, List<MessagesFilter> filters) {
        for (MessagesFilter filter : filters) {
            if (!filter.filter(message)) {
                return false;
            }
        }
        return true;
    }
}
