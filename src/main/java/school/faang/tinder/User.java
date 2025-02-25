package school.faang.tinder;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class User {

    private final String name;
    private boolean isOnline;
    private boolean isLookingForChat;
}
