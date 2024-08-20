package faang.school.godbless.SecondSprint.BJS2_22220;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String string, List<MessageFilter> filters) {
        for (MessageFilter filter : filters) {
            if (!filter.test(string)) {
                return false;
            }
        }
        return true;
    }
}
