package faang.school.godbless.BJS2_22094;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String str, List<MessageFilter> msgFilterList) {
        for (MessageFilter msgFilter : msgFilterList) {
            if (!msgFilter.filter(str)) {
                return false;
            }
        }
        return true;
    }
}
