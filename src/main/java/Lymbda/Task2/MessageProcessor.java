package Lymbda.Task2;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> messageFilters){
        boolean isFilter = false;
        for(MessageFilter fltr: messageFilters){
           if(fltr.filter(message)){
               isFilter = true;
               break;
           }
        }
        return isFilter;
    }
}
