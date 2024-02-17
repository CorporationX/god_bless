package faang.school.godbless.filtering.spam;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String massage, List<MessageFilter> filters) {
        boolean isFilteerd = false;
        for (MessageFilter massagesFiler : filters) {
            if (!massagesFiler.filter(massage)) {
                isFilteerd = true;
                break;
            }
        }
        return isFilteerd;
    }
}
