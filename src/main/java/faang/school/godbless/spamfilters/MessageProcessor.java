package faang.school.godbless.spamfilters;

import java.util.List;

public class MessageProcessor {

    public boolean processMessage(String message, List<MessageFilter> messageFilterList) {
        return messageFilterList.stream()
                .allMatch(messageFilter -> messageFilter.filter(message));

    }
}
