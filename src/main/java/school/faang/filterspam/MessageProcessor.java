package school.faang.filterspam;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String string, List<MessageFilter> messageFilterList) {
        return messageFilterList.stream().allMatch(each -> each.filter(string));
    }
}
