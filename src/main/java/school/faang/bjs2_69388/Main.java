package school.faang.bjs2_69388;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
            new User("Max", 17, "Facebook", "New York"),
            new User("Lev", 19, "Amazon", "Moscow"),
            new User("Din", 19, "Apple", "Dubai"),
            new User("Kim", 17, "Netflix", "Pyongyang"),
            new User("Ray", 19, "Google", "Georgetown")
        );

        Map<Integer, Set<User>> groupedUsers = User.groupUsers(users);

        for (Entry<Integer, Set<User>> entry : groupedUsers.entrySet()) {
            System.out.printf("%d %d -- %s\n", entry.getKey(), entry.getValue().size(), entry.getValue());
        }
    }
}
