package faang.school.godbless.lambdas.spamfiltering;

import java.util.List;

public class MessageProcessor {
    public void processMessage(String message, List<MessageFilter> messageFilters) {
        if (message == null || messageFilters == null) {
            throw new IllegalArgumentException();
        }

        boolean isFiltered = messageFilters.stream()
                .anyMatch(messageFilter -> messageFilter.filter(message));

        if (isFiltered) {
            System.out.printf("Сообщение скрыто (%s)\n", message);
        } else {
            System.out.println(message);
        }
    }
}
