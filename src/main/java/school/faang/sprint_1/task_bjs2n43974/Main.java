package school.faang.sprint_1.task_bjs2n43974;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        list.add(new User("Petr", 21, "MacD", "Street1"));
        list.add(new User("Olga", 22, "MacD", "Street2"));
        list.add(new User("John", 23, "KFC", "Street3"));
        list.add(new User("Emily", 23, "KFC", "Street3"));
        list.add(new User("Smith", 22, "KFC", "Street4"));
        list.add(new User("Kolya", 27, "KFC", "Street7"));
        list.add(new User("Tolya", 27, "KFC", "Street7"));
        list.add(new User("Anna", 23, "KFC", "Street14"));

        Map<Integer, List<User>> userMap = User.groupUsers(list);
        for (Map.Entry<Integer, List<User>> u : userMap.entrySet()) {
            System.out.printf("{%d - { %s }\n", u.getKey(), u.getValue());
        }

    }

}
