package faang.school.godbless.spam_filtering;

public class MessageProcessor {
    public boolean processMessage(String message, MessageFilter messageFilter) {
        return messageFilter.filter(message);
    }
}
