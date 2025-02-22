package tinder;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

@Slf4j
@Getter
public class UserList {
    private final List<User> users = new CopyOnWriteArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public List<User> getOnlineUsers() {
        return users.stream()
                .filter(u -> u.isOnline() && u.isLookingForChat())
                .collect(Collectors.toList());
    }
}
