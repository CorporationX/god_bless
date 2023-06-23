package faang.school.godbless.filteringSpam;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> messageFilters) {
        return messageFilters.stream().allMatch(MessageFilter -> MessageFilter.filter(message));
        // allMatch - не один элемент потока не соот. условию
    }
}
