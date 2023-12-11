package faang.school.godbless.lambda.task5filterspam;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> filters) {
        for (MessageFilter messageFilter : filters) {
            if (!messageFilter.filter(message)) {
                return true;
            }
        }
        return false;
    }
}
