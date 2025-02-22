package school.faang;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Getter
public class UserList {
    private final List<User> users;

    public List<User> getOnlineUsers(User user) {
        return users.stream()
                .filter(user2 -> !user2.isOnline() && user2.isLookingForChat() && user2 != user)
                .toList();
    }

    public void addUser(User user) {
        users.add(user);
        log.info("User {} added.", user.getName());
    }

    public void removeUser(User user) {
        users.remove(user);
        log.info("User {} removed.", user.getName());
    }
}
