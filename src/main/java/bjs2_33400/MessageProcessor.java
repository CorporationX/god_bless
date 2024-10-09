package bjs2_33400;

import java.util.List;

public class MessageProcessor {

    public boolean processMessage(String message,  List<MessageFilter> filters) {
        for (MessageFilter msgFilter : filters) {
            if (msgFilter.filter(message)) {
                return false;
            }
        }
        return true;
    }
}
