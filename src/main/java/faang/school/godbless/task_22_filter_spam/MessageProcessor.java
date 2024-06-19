package faang.school.godbless.task_22_filter_spam;

import java.util.List;

public class MessageProcessor {

    public boolean processMessage(String message, List<MessageFilter> filters){

        for (MessageFilter f : filters) {
            if(!f.filter(message)){
                return false;
            }
        }
        return true;
    }
}
