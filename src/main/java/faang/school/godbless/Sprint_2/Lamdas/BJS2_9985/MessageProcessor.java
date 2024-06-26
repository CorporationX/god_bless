package faang.school.godbless.Sprint_2.Lamdas.BJS2_9985;

import java.util.List;

import static java.util.Locale.filter;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> filters) {
        // Проходим по всем фильтрам
        for (MessageFilter filter : filters) {
            if (!filter.filter(message)) {
                // Если сообщение не проходит хотя бы один фильтр, возвращаем false
                return false;
            }
        }
        // Если сообщение прошло все фильтры, возвращаем true
        return true;
    }
}
