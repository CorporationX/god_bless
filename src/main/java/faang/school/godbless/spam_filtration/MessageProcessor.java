package faang.school.godbless.spam_filtration;

import java.util.List;

public class MessageProcessor {

    public boolean processMessage(String message, List<MessageFilter> messageFilters) {
        validateArguments(message, messageFilters);

        for (MessageFilter messageFilter : messageFilters) {
            boolean isFiltered = messageFilter.filter(message);
            if (!isFiltered) {
                return false;
            }
        }

        return true;
    }

    private void validateArguments(String message, List<MessageFilter> filtersList) {
        if (message.isBlank() || filtersList.isEmpty()) {
            throw new IllegalArgumentException("Arguments can't be empty");
        }
    }
}
