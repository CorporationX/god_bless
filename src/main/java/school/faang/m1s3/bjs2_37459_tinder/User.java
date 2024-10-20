package school.faang.m1s3.bjs2_37459_tinder;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@RequiredArgsConstructor
@Data
public class User {
    private final String name;
    private boolean isOnline = true;
    private boolean isLookingForChat;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
