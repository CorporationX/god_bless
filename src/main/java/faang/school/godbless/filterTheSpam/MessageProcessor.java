package faang.school.godbless.filterTheSpam;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String string, List<MessageFilter> filters) {
        for (MessageFilter filter : filters) {
            if(filter.filter(string)) {
                return true;
            }
        }
        return false;
    }
}
