package school.faang.grouping;

import java.util.List;
import java.util.Map;

import static school.faang.grouping.User.groupUsers;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(new User("Jacob", 27, "Google", "New York"),
                new User("Steve", 50, "Apple", "Cupertino"),
                new User("Ilon", 53, "SpaceX", "Austin"),
                new User("Bill", 69, "Microsoft", "Medina"),
                new User("Harry", 27, "Apple", "Washington"),
                new User("Alex", 50, "HP", "Los Angeles"),
                new User("Reynold", 53, "Xerox", "Houston"),
                new User("Chris", 21, "Nike", "San Antonio")
        );

        Map<Integer, List<User>> groupedByAge = groupUsers(users);
        for (Map.Entry entry : groupedByAge.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
