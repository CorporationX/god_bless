package school.faang.spring2.task_46323;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> filters) {
        boolean res = true;
        for (MessageFilter filter : filters) {
            res = filter.filter(message);
            if (!res) {
                return res;
            }
        }
        return res;
    }
}
