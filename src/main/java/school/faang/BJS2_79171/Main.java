package school.faang.BJS2_79171;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        List<User> myUserList = Arrays.asList(
                new User("Bob", 11),
                new User("Alice", 11),
                new User("Ronald", 13),
                new User("Pete", 14)
        );

        Map<Integer, List<User>> groupedMap = User.groupUsers(myUserList);

        groupedMap.forEach((age, userList) -> {
            System.out.println("Age group: " + age);
            userList.forEach(System.out::println);
        });
    }
}
