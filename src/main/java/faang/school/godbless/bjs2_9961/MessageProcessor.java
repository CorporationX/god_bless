package faang.school.godbless.bjs2_9961;

import java.util.List;

public class MessageProcessor {

  public Boolean processMessage(String message, List<MessageFilter> predicates) {
    return predicates.stream()
        .map(p -> p.filter(message))
        .filter(Boolean.FALSE::equals)
        .findFirst()
        .orElse(Boolean.TRUE);

  }

}
