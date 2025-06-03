package school.faang.bjs2_79171;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        List<User> myUserList = List.of(
                new User("Bob", 11, "school", "Maple st. 1"),
                new User("Alice", 11, null, null),
                new User("Ronald", 13, "office", "Elm st. 2"),
                new User("Pete", 14, null, null)
        );

        Map<Integer, List<User>> groupedMap = User.groupUsers(myUserList);

        groupedMap.forEach((age, userList) -> {
            System.out.println("Age group: " + age);
            userList.forEach(System.out::println);
        });
    }
}
