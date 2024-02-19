package faang.school.godbless.filterspam;

import java.util.List;

public class MessageProcessor {

    public static boolean processMessage(String message, List<MessageFilter> messageFilters) {
        for (MessageFilter filters : messageFilters) {
            if (!filters.filter(message)) {
                return false;
            }
        }
        return true;
    }
}
