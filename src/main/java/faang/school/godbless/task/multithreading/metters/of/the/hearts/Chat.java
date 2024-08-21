package faang.school.godbless.task.multithreading.metters.of.the.hearts;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Chat {
    private User master;
    private User opponent;

    public User getOpponent(User user) {
        return user.equals(master) ? opponent : master;
    }

    public void leave(User user) {
        if (user.equals(master)) {
            master = opponent;
        }
        opponent = null;
    }

    public boolean isAlive() {
        return opponent != null;
    }
}
