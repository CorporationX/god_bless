package Telegram;

import java.util.List;

public class MessageProcessor {
    public Boolean processMessage(String message, List<MessageFilter> filterList) {
        for (MessageFilter messageFilter : filterList) {
            if (!messageFilter.filter(message)) {
                return false;
            }
        }
        return true;
    }
}
