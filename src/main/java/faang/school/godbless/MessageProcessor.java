package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;

public class MessageProcessor {
    public List<Boolean> processMassage(String massage, List<MessageFilter> messageFilterList) {
        List<Boolean> resultFilter = new ArrayList<>();
        for (MessageFilter messageFilter : messageFilterList) {
            resultFilter.add(messageFilter.filter(massage));
        }
        return resultFilter;
    }
}
