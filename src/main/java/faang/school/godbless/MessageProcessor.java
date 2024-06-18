package faang.school.godbless;

import java.util.List;

public class MessageProcessor {

    public boolean processMessage(String massage, List<MessageFilter> messageFilters) {
        for (MessageFilter filter : messageFilters) {
            if(!filter.filter(massage))
                return false;
        }
        return true;
    }
}
