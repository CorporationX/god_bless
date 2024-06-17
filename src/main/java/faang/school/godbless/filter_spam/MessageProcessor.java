package faang.school.godbless.filter_spam;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> filters) {
        for (MessageFilter check : filters) {
            if(check.filter(message) == false){
                return false;
            }
        }
        return true;
    }
}
