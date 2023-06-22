package faang.school.godbless.FilterSpam;

import java.util.ArrayList;
import java.util.List;

public class MessageProcessor {
   public boolean processMessage(String message, List<MessageFilter> messageFilters) {
       return messageFilters.stream().allMatch(messageFilter -> messageFilter.filter(message));
    }
}
