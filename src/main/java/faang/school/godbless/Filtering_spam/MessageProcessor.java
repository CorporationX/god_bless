package faang.school.godbless.Filtering_spam;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String messageText, List<MessageFilter> messageFiltersList){
        boolean result = true;
        for (MessageFilter messageFilter: messageFiltersList) {
            System.out.println(messageFilter.filter(messageText));
            result = result & messageFilter.filter(messageText);
        }
        return result;
    }
}