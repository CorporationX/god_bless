package faang.school.godbless.BJS29976;

import java.util.List;

public class MessageProcessor {

    public boolean processMessage(String message, List<MessageFilter> filters) {
        boolean result = true;
        for (var filter : filters) {
            result = result & filter.filter(message);
        }
        return  result;
    }
}
