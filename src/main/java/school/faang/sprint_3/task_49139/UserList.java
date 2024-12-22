package school.faang.sprint_3.task_49139;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class UserList {
    private final List<User> users = new ArrayList<>();

    public synchronized List<User> getUsersReadyToChatWith(User user) {
        return users.stream()
                .filter(potentialUser -> potentialUser.isOnline()
                        && potentialUser.isLookingForChat()
                        && !potentialUser.equals(user))
                .toList();
    }

    public synchronized void addUser(User user) {
        users.add(user);
    }

    public synchronized void removeUser(User user) {
        users.remove(user);
    }
}
