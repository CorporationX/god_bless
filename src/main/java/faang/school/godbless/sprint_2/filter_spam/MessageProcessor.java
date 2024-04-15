package faang.school.godbless.sprint_2.filter_spam;

import java.util.List;

public class MessageProcessor {

    public boolean processMessage(String message, List<MessageFilter> messageFilters) {
        // Не совсем понял что в каком случае возвращать. Решил так: если все фильтры вернули true - возвращаю true, иначе false
        return messageFilters.stream().allMatch(messageFilter -> messageFilter.filter(message));
    }
}