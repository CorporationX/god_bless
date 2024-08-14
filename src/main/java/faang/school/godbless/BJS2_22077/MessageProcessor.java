package faang.school.godbless.BJS2_22077;

import java.util.List;

public class MessageProcessor {

    public boolean processMessage(String message, List<MessageFilter> filters) {
        if(message == null)
            throw new IllegalArgumentException("Message must contain text!");

       return filters.stream().allMatch(messageFilter -> messageFilter.filter(message));
    }
}
