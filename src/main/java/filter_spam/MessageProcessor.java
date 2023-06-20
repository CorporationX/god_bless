package filter_spam;

import java.util.List;

public class MessageProcessor {
    /**
     * Если какой-либо фильтр не работает (возвращает true),
     * метод возвращает true, указывая на то, что сообщение отфильтровано.
     * Отрицание ! используется с filter.filter(message), чтобы проверить,
     * возвращает ли фильтр false, указывая, что фильтр не применяется.
     *
     * @param message
     * @param filters
     */
    public boolean processMessage(String message, List<MessageFilter> filters) {
        return filters.stream()
                .anyMatch(filter -> !filter.filter(message));
    }
}
