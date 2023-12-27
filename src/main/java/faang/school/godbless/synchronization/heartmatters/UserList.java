package faang.school.godbless.synchronization.heartmatters;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
public class UserList {

    private final List<User> users;

    public UserList() {
        users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public Optional<User> getAvailableUser() {
        return users.stream().filter(user -> user.isAvailable() && user.isOnline()).findFirst();
    }

}
