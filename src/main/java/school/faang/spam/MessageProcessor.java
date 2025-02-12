package school.faang.spam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MessageProcessor {
    private static final Logger logger = LoggerFactory.getLogger(MessageProcessor.class);

    public boolean processMessage(String message, List<MessageFilter> filters) {
        checkMessage(message);
        checkFilters(filters);
        for (MessageFilter filter : filters) {
            if (!filter.filter(message)) {
                return false;  // Сообщение заблокировано фильтром
            }
        }
        return true;  // Сообщение прошло все фильтры
    }

    public void checkMessage(String message) {
        if (message == null) {
            logger.error("Filters list cannot be null");
        }
    }

    public void checkFilters(List<MessageFilter> filters) {
        if (filters == null) {
            logger.error("Filters cannot be null");
        }
    }
}

