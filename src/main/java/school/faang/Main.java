package school.faang;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Mike", 25, "Google", "Paris"));
        users.add(new User("John", 20, "Amazon", "Madrid"));
        users.add(new User("Alice", 25, "Microsoft", "Mexico"));
        users.add(new User("Anna", 28, "Apple", "Moscow"));
        users.add(new User("Maria", 28, "Uber", "Bangkok"));
        users.add(new User("Robert", 28, "META", "Lisbon"));

        Map<Integer, List<User>> sortedUsers = User.groupUsers(users);
        for(var entry : sortedUsers.entrySet()) {
            System.out.println("Age: " + entry.getKey());
            for(User user : entry.getValue()) {
                System.out.println(" " + user);
            }
        }
    }
}