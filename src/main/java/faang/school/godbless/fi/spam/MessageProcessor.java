package faang.school.godbless.fi.spam;

import java.util.List;

public class MessageProcessor {

    public boolean processMessage(String message, List<MessageFilter> filters) {
        if(message == null)
            throw new IllegalArgumentException("> message must contain text!");

       return filters.stream().allMatch(messageFilter -> messageFilter.filter(message));
    }

}
