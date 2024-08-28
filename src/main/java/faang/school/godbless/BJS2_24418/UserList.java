package faang.school.godbless.BJS2_24418;

import lombok.Getter;

import java.util.List;


@Getter
public class UserList {
    private List<User> users;

    public List<User> getOnlineUsers(User user) {
        List<User> onlineUsers = users.stream()
                .filter(User::isOnline)
                .toList();
        onlineUsers.remove(user);
        return onlineUsers;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }
}
