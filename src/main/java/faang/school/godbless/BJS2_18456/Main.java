package faang.school.godbless.BJS2_18456;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        List<User> users = List.of(
                new User("Bob", 23, "C++ dev", "Heaven"),
                new User("John", 29, "Java dev", "Earth"),
                new User("Den", 29, "Python dev", "Hell")
        );

        Map<Integer, List<User>> groupedUsersMap = User.groupUsers(users);
        groupedUsersMap.entrySet().forEach(System.out::println);
    }
}