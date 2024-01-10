package faang.school.godbless.alexbulgakoff.multithreading.synchronization.mattersoftheheart;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexander Bulgakov
 */

public class UserList {
    private final List<User> allUserList;

    public UserList() {
        this.allUserList = new ArrayList<>();
    }

    public void addUser(User newUser) {
        allUserList.add(newUser);
    }

    public User getOnlineUser() {
        return allUserList.stream()
                .filter(User::isOnline).findFirst().orElseThrow();
    }
}
