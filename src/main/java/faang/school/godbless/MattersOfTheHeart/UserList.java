package faang.school.godbless.MattersOfTheHeart;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserList implements Iterable<User> {
    private final List<User> users;

    public UserList(List<User> users) {
        this.users = new ArrayList<>(users);
    }

    public synchronized void addUser(User user) {
        users.add(user);
        notify();
    }

    public synchronized void removeUser(User user) {
        users.remove(user);
    }

    public synchronized boolean isEmpty() {
        return users.isEmpty();
    }

    @Override
    public Iterator<User> iterator() {
        return users.iterator();
    }
}