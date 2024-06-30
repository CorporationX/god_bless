package faang.school.godbless.sprint_3.multithreading_synchronization.task_7_tinder;

import java.util.ArrayList;
import java.util.List;

public class UserList {

    public final List<User> users = new ArrayList<>();

    public void addUser(User user) {
        synchronized (users) {
            users.add(user);
            // появился пользователь, может быть он тот самый?
            // надо разморозить ждуна
            users.notify();
        }
    }
}
