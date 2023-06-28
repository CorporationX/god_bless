package faang.school.godbless.sprint3.Filter_for_spam;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String str, List<MessageFilter> filters) {
        for (MessageFilter filter : filters) {
            if (!filter.act(str)) {
                return false;
            }
        }
        return true;
    }
}
