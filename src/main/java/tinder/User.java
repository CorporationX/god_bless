package tinder;

import lombok.Data;
import lombok.NonNull;

@Data
public class User {
    @NonNull
    private final String name;
    private boolean isOnline;
    private boolean isLookingForChat;
}
