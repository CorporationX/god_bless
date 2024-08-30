package matters.of.heart;

import lombok.Getter;

import java.util.*;

@Getter
public class UserList {
    private final List<User> users;
    private final List<User> waitingUsers = new ArrayList<>();
    private final Object lock = new Object();

    UserList(List<User> users) {
        this.users = users;
    }

    public List<User> getOnlineUsers() {
        return this.users.stream()
            .filter(User::isOnline)
            .toList();
    }

    public void addUserToWaitList(User user) {
        synchronized (this.lock) {
            if (this.waitingUsers.contains(user)) {
                return;
            }
            this.waitingUsers.add(user);
            System.out.printf("+Пользователь %s добавлен в список ожидания\n", user.getName());
            this.lock.notifyAll();
        }
    }

    public Optional<User> getUserForChat(User user) {
        return this.waitingUsers.stream()
            .filter(u -> !user.equals(u))
            .filter(u -> user.getActiveChat().isEmpty())
            .findFirst();
    }

    public void removeUserInWaitList(User user) {
        this.waitingUsers.remove(user);
    }
}
