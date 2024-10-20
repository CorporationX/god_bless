package school.faang.heartMatters;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class UserList {
    private static final Random random = new Random();
    private final List<User> users = new ArrayList<>();

    public void initializeRandomUsers() {
        List<String> names = List.of("John", "Emily", "Michael", "Sarah", "David", "Jessica", "Daniel",
                "Sophia", "James", "Olivia", "Robert", "Emma", "William", "Ava", "Joseph", "Isabella",
                "Matthew", "Mia", "Andrew", "Charlotte");

        for (String name : names) {
            User user = new User(name, random.nextBoolean(), random.nextBoolean());
            users.add(user);
        }
    }

    public List<User> getOnlineUsers() {
        return users.stream()
                .filter(User::isOnline)
                .toList();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }
}
