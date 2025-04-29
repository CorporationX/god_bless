package school.faang.tinder;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class UserList {
    private final List<User> users = new ArrayList<>();
    private final Object lock = new Object();

    public List<User> getOnlineUsers() {
        synchronized (lock) {
            List<User> onlineUsers = new ArrayList<>();
            for (User user : users) {
                if (user.isOnline() && user.isLookingForChat()) {
                    onlineUsers.add(user);
                }
            }
            return onlineUsers;
        }
    }

    public void addUser(User user) {
        synchronized (lock) {
            users.add(user);
        }
    }

    public void removeUser(User user) {
        synchronized (lock) {
            users.remove(user);
        }
    }
}
