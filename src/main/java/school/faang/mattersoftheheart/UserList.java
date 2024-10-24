package school.faang.mattersoftheheart;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserList {
    private final List<User> users = new ArrayList<>();

    public synchronized void addUser(User user) {
        users.add(user);
        System.out.println("User added: " + user.getName());
    }

    public synchronized void removeUser(User user) {
        users.remove(user);
        System.out.println("User removed: " + user.getName());
    }

    public List<User> getOnlineUsers() {
        return users.stream()
                .filter(user -> user.isOnline() && user.isLookingForChat())
                .collect(Collectors.toList());
    }
}

