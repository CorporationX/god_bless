package school.faang.bjs_87778;

import java.util.List;


public class MessageProcessor {
    static boolean processMessage(String message, List<MessageFilter> filters) {
        for (MessageFilter filter1 : filters) {
            if (filter1.filter(message)) {
                return true;
            }
        }
        return false;
    }
}
