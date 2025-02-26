package school.faang.mattersoftheheart;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
public class UserList {
    private final List<User> users = new ArrayList<>();

    public List<User> getReadyToChattingUsers() {
        return users.stream()
                .filter(user -> user.isOnline() && user.isLookingForChat())
                .toList();
    }

    public void addUser(User user) {
        validateUser(user);
        if (users.contains(user)) {
            log.warn("User {} is already in list", user);
        } else {
            users.add(user);
        }
    }

    public void removeUser(User user) {
        validateUser(user);
        if (!users.contains(user)) {
            log.warn("User {} is not in list", user);
        } else {
            users.remove(user);
        }
    }

    private void validateUser(User user) {
        Objects.requireNonNull(user, "Invalid user value");
    }

    private String userOnlineStatus(User user) {
        if (user.isOnline()) {
            return "online";
        }
        return "offline";
    }

    private String userChattingStatus(User user) {
        if (user.isLookingForChat()) {
            return "ready to chatting";
        }
        return "busy";
    }

    public void printAllUsers() {
        users.forEach((user) -> log.info("Name: {} ({}), status: {}",
                user.getName(), userOnlineStatus(user), userChattingStatus(user)));
    }
}
