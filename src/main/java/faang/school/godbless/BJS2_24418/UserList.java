package faang.school.godbless.BJS2_24418;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


@Getter
public class UserList {
    private List<User> users = new ArrayList<>();

    public List<User> getOnlineUsers() {
        return users.stream()
                .filter(User::isOnline)
                .toList();
    }

    public void addUser(User user) {
        users.add(user);
    }
}
