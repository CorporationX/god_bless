package school.faang.tinder;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Message {
    private int messageId;
    private User messageOwner;
    private String content;
    private LocalDateTime sendingTime;
    private boolean viewedByRecipient;
}
