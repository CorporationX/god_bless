package faang.school.godbless.task.lambda.spam.filtering;

import java.util.List;

public class MessageProcessor {

    public boolean processMessage(String message, List<MessageFilter> MessageFilters){
        for (MessageFilter messageFilter : MessageFilters){
            if(!messageFilter.filter(message)){
                return false;
            }
        }
        return true;
    }
}
