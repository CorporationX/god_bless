package school.faang.task219.message;

import java.util.List;
import java.util.stream.Collectors;

public class MessageProcessor {
    public static boolean processMessage(String message, List<MessageFilter> filters){
        return filters.stream()
                .allMatch(filter -> filter.filter(message));
    }
}
