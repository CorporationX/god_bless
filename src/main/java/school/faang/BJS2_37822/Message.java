package school.faang.BJS2_37822;

import java.util.concurrent.atomic.AtomicInteger;

public class Message {
    private static final AtomicInteger messageCount = new AtomicInteger(0);
    private final String subject;
    private final String message;
    private final int messageNumber;

    public Message(String subject, String message) {
        this.subject = subject;
        this.message = message;
        messageNumber = messageCount.incrementAndGet();
    }

    @Override
    public String toString(){
        return "Message number: " + messageNumber + "  Subject: " + subject + "  Message: " + message;
    }
}
