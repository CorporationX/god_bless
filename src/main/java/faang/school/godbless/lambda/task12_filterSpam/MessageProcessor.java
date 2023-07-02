package faang.school.godbless.lambda.task12_filterSpam;

import java.util.List;

public class MessageProcessor{
    public boolean processMessage(String message, List<MessageFilter> filters){
        for (MessageFilter messageList: filters) {
            messageList.filter(message);
        }
        return false;
    }
}
