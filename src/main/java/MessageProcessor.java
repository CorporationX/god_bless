import java.util.List;

public class MessageProcessor {
    boolean processMessage(String message, List<MessageFilter> messageFilters) {
        int filterCounter = messageFilters.size();

        for (MessageFilter messageFilter : messageFilters) {
            if (messageFilter.filter(message)) {
                filterCounter--;
            }
        }

        return filterCounter == 0;
    }
}
