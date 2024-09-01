package matters_of_the_heart;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Getter
public class UserList {
    private final List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public Optional<User> getUserBy(int id) {
        return users.stream()
                .filter(user -> Objects.equals(user.getId(), id))
                .findFirst();
    }

    public List<User> getOnlineUsers() {
        return users.stream()
                .filter(User::isOnline)
                .toList();
    }
}
