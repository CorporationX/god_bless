package faang.school.godbless.javasynchronized.task7;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class UserList {
    private final List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }
}
