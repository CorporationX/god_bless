package matters_of_the_heart;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    private List<User> userList;

    public UserList() {
        userList = new ArrayList<>();
    }

    public List<User> getUsersEligibleToStartChat(User user) {
        return userList.stream()
                .filter(u -> u.isEligible() && !u.equals(user))
                .toList();
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public List<User> getUserList() {
        return userList;
    }
}
