package faang.school.godbless.lambda.spam_telegram;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String word, List<MessageFilter> messageFilters){
        for(MessageFilter messageFilter : messageFilters){
            if(!messageFilter.filter(word)){
                return false;
            }
        }
        return true;
    }
}
