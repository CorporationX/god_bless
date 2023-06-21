package faang.school.godbless.FilterOfSpam;

import java.util.*;

public class MessageProcessor {
    public Boolean processMessage(String message, List<MessageFilter> filters){
        for (var eachFilter : filters){
            if(eachFilter.filter(message)){
                return false;
            }
        }
        return true;
    }
}
