package tinder;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Chat {
    @NonNull
    private final User user1;
    @NonNull
    private final User user2;

    @Override
    public String toString() {
        return "Chat between " + user1.getName() + " and " + user2.getName();
    }
}
