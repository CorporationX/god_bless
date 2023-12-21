package faang.school.godbless.multi.task9tinder;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


@Getter
public class UserList {
    private final List<User> users = new ArrayList<>();

    public synchronized void addUser(User user) {
        users.add(user);
        System.out.println("Пользователь добавлен: " + user.getName());
    }

    public synchronized List<User> getOnlineUsers() {
        return users.stream().filter(User::isOnline).toList();
    }
}
