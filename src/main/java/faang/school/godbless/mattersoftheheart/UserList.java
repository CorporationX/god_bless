package faang.school.godbless.mattersoftheheart;

import java.util.ArrayList;
import java.util.List;

public class UserList {

    private final List<User> allUsers = new ArrayList<>();

    public void addUser(User user) {
        allUsers.add(user);
    }

    public List<User> getWantedToChatUsers() {
        return allUsers.stream().filter(User::isWantToChat).toList();
    }
}
