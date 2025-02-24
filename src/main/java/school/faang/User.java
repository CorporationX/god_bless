package school.faang;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class User {
    private final String name;
    private boolean isOnline;
    private boolean isLookingForChat;
    private Chat chat;
}
