package school.faang.spamfiltering;

import java.util.List;

public class MessageProcessor {

    public boolean processMessage(String message, List<MessageFilter> filters){
        return filters.stream().allMatch(m -> m.filter(message));
    }
}
