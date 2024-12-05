package school.faang.sprint_1.task_bjs2n43974;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> list = new ArrayList<>(Arrays.asList(
                new User("Petr", 21, "MacD", "Street1"),
                new User("Olga", 22, "MacD", "Street2"),
                new User("John", 23, "KFC", "Street3"),
                new User("Emily", 23, "KFC", "Street3"),
                new User("Smith", 22, "KFC", "Street4"),
                new User("Kolya", 27, "KFC", "Street7"),
                new User("Tolya", 27, "KFC", "Street7"),
                new User("Anna", 23, "KFC", "Street14")));

        Map<Integer, List<User>> userMap = User.groupUsers(list);
        for (Map.Entry<Integer, List<User>> u : userMap.entrySet()) {
            System.out.printf("{%d - { %s }\n", u.getKey(), u.getValue());
        }

    }

}
