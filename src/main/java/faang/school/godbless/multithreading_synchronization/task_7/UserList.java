package faang.school.godbless.multithreading_synchronization.task_7;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    public List<User> getOnlineUsers() {
        final List<User> users = getAllUsers();
        return users.stream()
                .filter(user -> user.getStatus() == Status.ONLINE)
                .toList();
    }

    private List<User> getAllUsers() {
        final ArrayList<User> users = new ArrayList<>();
        users.add(new User("Alex", Status.ONLINE, true));
        users.add(new User("Caitlyn", Status.ONLINE, true));
        users.add(new User("Satoru Gojo", Status.ONLINE, false));
        users.add(new User("Zaur", Status.ONLINE));
        users.add(new User("David", Status.OFFLINE));
        users.add(new User("Jojo", Status.ONLINE, true));
        return users;
    }
}
