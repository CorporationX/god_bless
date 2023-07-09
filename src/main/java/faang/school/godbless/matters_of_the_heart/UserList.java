package faang.school.godbless.matters_of_the_heart;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    List<User> userList = new ArrayList<>();


    public synchronized void addUser(User user) {
        userList.add(user);
    }

    public synchronized void deleteUser(User user) {
        userList.remove(user);
    }

    public synchronized List<User> getOnlineUser() {
        return userList.stream().filter(user -> user.isOnline()).toList();
    }

    public boolean doesAnyWantChat() {
        return userList.stream().anyMatch(user -> user.isPrepareToChat());
    }
}
