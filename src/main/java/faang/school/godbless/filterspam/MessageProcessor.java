package faang.school.godbless.filterspam;

import java.util.List;

public class MessageProcessor {

    public static boolean processMessage(String message, List<MessageFilter> messageFilter) {
        for (MessageFilter filters : messageFilter) {
            if (!filters.filter(message)) {
                return false;
            }
        }
        return true;
    }
}
