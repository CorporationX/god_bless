package faang.school.godbless.tinder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserList {

    private static List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public Optional<User> getOnlineUser() {
        return users.stream().filter(u -> u.isOnline() && u.isWaitChat()).findFirst();
    }
}
