package school.faang.sprint_1.task_bjs244000;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<User> testUserList = List.of(
                new User(1, "Jack", 18, Set.of("poker", "java", "sql")),
                new User(2, "John", 24, Set.of("cars", "spring", "weapons")),
                new User(3, "Vika", 43, Set.of("swimming", "bike", "hiking")),
                new User(4, "Ashley", 23, Set.of("TV", "C", "java")),
                new User(5, "Bob", 75, Set.of("disco", "fortran", "music"))
        );
        Set<String> testActivities = Set.of("cars", "dance", "reading");
        Set<String> testActivities2 = Set.of("java", "bike", "music");
        Set<String> testActivities3 = null;

        System.out.println(User.findHobbyLovers(testUserList, testActivities));
        System.out.println("--------------------------------");
        System.out.println(User.findHobbyLovers(testUserList, testActivities2));
        System.out.println("--------------------------------");
        System.out.println(User.findHobbyLovers(testUserList, testActivities3));
    }
}
