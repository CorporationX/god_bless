package faang.school.godbless.sprint3.SpamFilter;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> handlers) {
        boolean answer = true;
        for(MessageFilter handler : handlers) {
            answer &= handler.filter(message);
        }
        return answer;
    }
}
