package faang.school.godbless.multithreading.synchronizedPractice.mattersOfTheHeart;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    private final List<User> users;

    public UserList() {
        users = new ArrayList<>();
    }

    public List<User> getUsersEligibleToStartChat(User user) {
        return users.stream()
                .filter(u -> u.isEligible() && !u.equals(user))
                .toList();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public List<User> getUserList() {
        return users;
    }
}
