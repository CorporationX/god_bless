package faang.school.godbless.synchronizationWaitNotify.matterOfTheHeart;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.Random;

@Getter
@Setter
public class User {
    private String name;
    private boolean isOnline;

    private final Random random = new Random();

    public User(String name) {
        this.name = name;
        isOnline = random.nextBoolean();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
