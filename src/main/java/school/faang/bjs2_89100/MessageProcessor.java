package school.faang.bjs2_89100;

import java.util.List;

public class MessageProcessor {

    public boolean processMessage(String message, List<MessageFilter> filters) {
        boolean flag = true;
        for (MessageFilter filter : filters) {
            if (!filter.filter(message)) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}