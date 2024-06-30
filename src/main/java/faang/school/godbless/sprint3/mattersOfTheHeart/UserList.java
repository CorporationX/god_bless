package faang.school.godbless.sprint3.mattersOfTheHeart;

import java.util.List;

public class UserList {

    private final List<User> users;
    private final Object lock = new Object();

    public UserList(List<User> onlineUsers) {
        this.users = onlineUsers;
    }

    public List<User> getUsers() {
        synchronized (lock) {
            return users;
        }
    }

    public void addUser(User user) {
        synchronized (lock) {
            users.add(user);
        }
    }

    public Object getLock() {
        return lock;
    }

    @Override
    public String toString() {
        return "UserList{" +
                "users=" + users +
                ", lock=" + lock +
                '}';
    }
}
