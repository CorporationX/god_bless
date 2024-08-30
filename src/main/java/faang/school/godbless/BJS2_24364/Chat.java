package faang.school.godbless.BJS2_24364;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Chat {
    private final User userOne;
    private final User userTwo;

    public boolean contains(User user) {
        return userOne.equals(user) || userTwo.equals(user);
    }
}
