package school.faang.spam;

import java.util.List;

/**
 * @author Danil Pudovkin
 * @since 11.06.2025
 */
public class MessageProcessor {

    public boolean processMessage(String message, List<MessageFilter> filters) {
        for (var filter : filters) {
            var isAccepted = filter.filter(message);
            if (!isAccepted) {
                return false;
            }
        }
        return true;
    }
}
