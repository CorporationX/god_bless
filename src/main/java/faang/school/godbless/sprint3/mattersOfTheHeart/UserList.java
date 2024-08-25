package faang.school.godbless.sprint3.mattersOfTheHeart;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

@AllArgsConstructor
public class UserList {
    private final List<User> users;

    public synchronized List<User> getOnlineUsers() {
        return users.stream()
                .filter(User::isOnline)
                .toList();
    }

    public synchronized void changeStatus(Predicate<User> predicate) {
        users.stream()
                .filter(user -> !user.isOnline() && predicate.test(user))
                .forEach(user -> user.setOnline(new Random().nextBoolean()));
        this.notifyAll();
    }
}
