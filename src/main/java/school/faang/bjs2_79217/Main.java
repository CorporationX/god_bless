package school.faang.bjs2_79217;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Alice", 25, "Google", "Mountain View"),
                new User("Bob", 27, "Yandex", "Moscow"),
                new User("Charlie", 28, "Uber", "Sun Francesco"),
                new User("David", 25, "Meta", "Menlo Park"),
                new User("Emma", 27, "Amazon", "Seattle"),
                new User("Frank", 27, "Netflix", "Los Gates"),
                new User("Grace", 28, "Apple", "Cupertino")
        );

        Map<Integer, List<User>> result = User.groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry : result.entrySet()) {
            System.out.println("Age: " + entry.getKey());
            System.out.println("Users: " + entry.getValue());
            System.out.println();
        }
    }
}
