package faang.school.godbless.spam;

import java.util.List;

public class MessageProcessor {

    public boolean processMessage(String message, List<MessageFilter> filterList) {
        boolean isApropriate = false;

        if (message != null) {
            for (MessageFilter messageFilter : filterList) {
                isApropriate = messageFilter.filter(message);
                if (!isApropriate) {
                    break;
                }
            }

        }

        return isApropriate;
    }
}
