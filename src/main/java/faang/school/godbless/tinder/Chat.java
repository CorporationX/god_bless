package faang.school.godbless.tinder;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Chat {
    private User user1;
    private User user2;

    @Override
    public String toString() {
        return "Chat between " + user1.getName() + " and " + user2.getName();
    }
}
