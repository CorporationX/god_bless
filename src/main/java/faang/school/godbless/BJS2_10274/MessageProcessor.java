package faang.school.godbless.BJS2_10274;

import java.util.List;


public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> messageFilters) {
        if (message == null || message.trim().isEmpty() || messageFilters == null) throw new IllegalArgumentException();

       return messageFilters.stream().map(p -> p.filter(message))
               .filter(Boolean.FALSE::equals)
               .findFirst()
               .orElse(Boolean.TRUE);

    }
}
