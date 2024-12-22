package school.faang.task49140;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Getter
@RequiredArgsConstructor
public class UserList {
    private final List<User> users;

    public List<User> getOnlineUser() {
        return users.stream()
                .parallel()
                .filter(user -> user.isOnline() && user.isLookingChat())
                .toList();
    }

    public void addUser(User user) {
        if (users.contains(user)) {
            log.warn("{} уже существует.", user);
            return;
        }
        users.add(user);
    }

    public void removeUser(User user) {
        if (!users.contains(user)) {
            log.warn("Невозможно удалить {}.", user);
            return;
        }
        users.remove(user);
    }
}
