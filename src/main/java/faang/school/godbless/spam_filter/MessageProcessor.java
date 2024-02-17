package faang.school.godbless.spam_filter;

import java.util.List;
public class MessageProcessor {
    public static boolean processMessage(String message, List<MessageFilter> list) {

        return false;
    }
}

    interface MessageFilter {
        boolean isFilter(String message);
    }

    class filterOrNofilter implements MessageFilter {
        @Override
        public boolean isFilter(String message) {
            return message != null && !message.isBlank() && message.contains("Spam") && message.contains("\uD83D\uDE00");
        }
    }
