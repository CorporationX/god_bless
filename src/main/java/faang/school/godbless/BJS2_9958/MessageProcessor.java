package faang.school.godbless.BJS2_9958;

import java.util.List;

public class MessageProcessor {
  public boolean processMessage(String message, List<MessageFilter> messageFilters) {
    return messageFilters.stream().allMatch(s -> s.filter(message));
  }
}
