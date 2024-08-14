package faang.school.godbless.BJS2_22096;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> filters) {
        boolean test = false;
        for (MessageFilter filter : filters) {
            if (filter.filter(message)) {
                test = true;
            }
        }
        return test;
    }
}
