package faang.school.godbless.BJS2_24418;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
public class UserList {
    @Getter
    private List<User> users;

    public List<User> getOnlineUsers() {
        return users.stream()
                .filter(User::isOnline)
                .toList();
    }

    public void addUser (User user) {
        users.add(user);
    }

    public void removeUser (User user) {
        users.remove(user);
    }
}
