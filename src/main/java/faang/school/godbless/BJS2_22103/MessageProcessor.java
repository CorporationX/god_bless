package faang.school.godbless.BJS2_22103;

import java.util.List;

public class MessageProcessor {
    public static void processMessage(String message, List<MessageFilter> messageFilters) {
        for (int i = 0; i < messageFilters.size(); i++) {
            MessageFilter filter = messageFilters.get(i);
            if (!filter.filter(message)) {
                System.out.printf("Не прошел %d по счету фильтр.%n", i + 1);
                return;
            }
        }
        System.out.println(message);
    }
}
