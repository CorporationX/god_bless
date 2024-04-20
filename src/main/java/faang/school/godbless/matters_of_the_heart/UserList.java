package faang.school.godbless.matters_of_the_heart;

import java.util.List;

public class UserList {
    private List<User> users;

    public List<User> getOnlineUsers() {
        return users.stream()
                .filter(User::isOnline).toList();
    }

    public void addUser(User user) {
        users.add(user);
    }
}
