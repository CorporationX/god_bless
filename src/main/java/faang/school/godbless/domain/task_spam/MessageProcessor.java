package faang.school.godbless.domain.task_spam;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> list) {
        boolean result = false;
        for (MessageFilter obj : list) {
            if (obj.filter(message))
                result = true;
        }
        return result;

    }
}
