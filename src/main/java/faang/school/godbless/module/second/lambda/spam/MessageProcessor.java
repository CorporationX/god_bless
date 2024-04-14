package faang.school.godbless.module.second.lambda.spam;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> filters) {
        for (MessageFilter filterPredicate : filters) {
            if (!filterPredicate.filter(message)) {
                return false;
            }
        }
        return true;
    }
}
