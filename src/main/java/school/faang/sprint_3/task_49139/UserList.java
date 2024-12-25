package school.faang.sprint_3.task_49139;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
public class UserList {
    private final List<User> users = new ArrayList<>();

    public synchronized Optional<User> getUserReadyToChatWith(User user) {
        return users.stream()
                .filter(potentialUser -> potentialUser.isOnline()
                        && potentialUser.isLookingForChat()
                        && !potentialUser.equals(user))
                .findFirst();
    }

    public synchronized void addUser(User user) {
        users.add(user);
    }

    public synchronized void removeUser(User user) {
        users.remove(user);
    }
}
