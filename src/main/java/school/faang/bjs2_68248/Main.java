package school.faang.bjs2_68248;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Miras", 19, "Yandex", "Baker Street 221B"));
        users.add(new User("Alice", 25, "Google", "1600 Amphitheatre Parkway"));
        users.add(new User("Bob", 30, "Microsoft", "One Microsoft Way"));
        users.add(new User("Charlie", 19, "Amazon", "410 Terry Ave N"));
        users.add(new User("Diana", 25, "Apple", "1 Apple Park Way"));


        Map<Integer, List<User>> grouped = User.groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry : grouped.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue().toString());
        }

    }
}
