package school.faang.bjs2_80937;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> listFilters) {
        if (message == null) {
            log.info("Сообщение не может быть null");
            return false;
        }

        for (MessageFilter filter : listFilters) {
            if (!filter.filter(message)) {
                return false;
            }
        }
        return true;
    }
}
