package faang.school.godbless.spam_filter;

import java.util.List;

public class MessageProcessor {
    private static void processMessage(String message, List<MessageFilter> list) {

    }

    public interface MessageFilter() {
        private static void filter(String message) {
            boolean isFilter;
        }
    }
}
