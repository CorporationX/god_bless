package filterSpam;

import java.util.List;

public class MessageProcessor {

    public static boolean processMessage(String message, List<MessageFilter> messageFilterList) {
        boolean skip = false;
        for (MessageFilter filter : messageFilterList) {
                if (message != null) {
                    if (filter.filter(message)) {
                        skip = true;
                        break;
                    }
                } else {
                    throw new IllegalArgumentException();
                }
        }
        return skip;
    }
}
