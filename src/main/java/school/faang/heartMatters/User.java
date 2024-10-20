package school.faang.heartMatters;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class User {
    private final String name;
    private boolean isOnline;
    private boolean isLookingForChat;
}
