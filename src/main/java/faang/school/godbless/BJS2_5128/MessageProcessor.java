package faang.school.godbless.BJS2_5128;

import java.util.List;

public class MessageProcessor {
  public boolean processMessage(String message, List<MessageFilter> filters) {
    return filters.stream().allMatch(messageFilter -> messageFilter.filter(message));
  }
}
