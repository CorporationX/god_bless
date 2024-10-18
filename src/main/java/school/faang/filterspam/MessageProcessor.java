package school.faang.filterspam;

import java.util.List;

public class MessageProcessor {

    public boolean processMessage(String message, List<MessageFilter> listOfFilters) {

        for (MessageFilter messageFilter : listOfFilters) {
            if (messageFilter.filter(message)) {
                return false;
            }
        }
        return true;
    }
}
