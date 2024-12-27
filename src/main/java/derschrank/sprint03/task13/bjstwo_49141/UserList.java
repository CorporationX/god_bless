package derschrank.sprint03.task13.bjstwo_49141;

import java.util.ArrayList;
import java.util.List;

public class UserList implements UserListInterface {
    private List<User> users;

    public UserList() {
        users = new ArrayList<>();
    }

    @Override
    public List<User> getOnlineUsersAwaitForNewChat() {
        List<User> copyOfUsers;
        synchronized (this) {
            copyOfUsers = new ArrayList<>(users);
        }

        return copyOfUsers.stream()
                .filter(User::isAwaitForNewChat)
                .toList();
    }

    @Override
    public synchronized void addUser(User user) {
        users.add(user);
    }

    @Override
    public synchronized void removeUser(User user) {
        users.remove(user);
    }

    public synchronized List<User> getUsers() {
        return new ArrayList<>(users);
    }
}
