package school.faangSprint3.t11;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message {
    private final User sender;
    private final String content;
    private final LocalDateTime timestamp;

    public Message(User sender, String content) {
        this.sender = sender;
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return String.format("[%s] %s: %s",
                timestamp.format(formatter), sender.getName(), content);
    }
}