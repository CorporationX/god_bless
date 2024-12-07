package school.faang.sprint2.task47010.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Notification {
    private MessageType type;
    private String message;
}
