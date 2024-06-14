package faang.school.godbless.module1.sprint2.task7;

import java.util.List;

public class MessageProcessor {

    public boolean processMessage(String message, List<MessageFilter> messages) {
        for (MessageFilter filter : messages) {
            if (!filter.filter(message)) {
                return false;
            }
        }
        return true;
    }
}
