package faang.school.godbless;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> messageFilter){
        for (MessageFilter filter:messageFilter){
            if(!filter.filter(message)){
                return false;
            }
        }
        return true;
    }
}
