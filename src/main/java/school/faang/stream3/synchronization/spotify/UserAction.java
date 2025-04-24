package school.faang.stream3.synchronization.spotify;

import java.util.function.Consumer;

public class UserAction implements Runnable {
    private User user;
    private Consumer<Player> action;

    public UserAction(User user, Consumer<Player> action) {
        this.user = user;
        this.action = action;
    }

    @Override
    public void run() {
        action.accept(user.getPlayer());
    }
}
