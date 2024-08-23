package heart;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDateTime;

@Getter
@EqualsAndHashCode
public class Message {
    private final String content;
    private final LocalDateTime timestamp;

    public Message(@NonNull String content) {
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }

    public boolean isValid() {
        return !(content.isEmpty() || content.isBlank());
    }
}
