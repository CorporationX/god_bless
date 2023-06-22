import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> messageFilters) {

        return messageFilters.stream().anyMatch(messageFilter -> !messageFilter.filter(message));
    }
}
