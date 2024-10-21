package school.faang.tinder;

import java.time.LocalDateTime;
import java.util.Objects;

public record Message(
        int messageId,
        int chatId,
        User messageOwner,
        String content,
        LocalDateTime sendingTime
) {

    public Message(User messageOwner, String content, int chatId) {
        this(Objects.hash(chatId, messageOwner),
                chatId, messageOwner, content, LocalDateTime.now());
    }
}
