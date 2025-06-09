package school.faang.groupingTask;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class GroupingTest {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Marsel Ysupov", "Narnia", "philanthropist", 25),
                new User("Frodo Begins", "Shire", "traveler", 55),
                new User("Ronald Weasley", "Hogwarts", "wizard", 18),
                new User("Peter Parker", "New York", "Spider Man", 18));


        Map<Integer, List<User>> usersMap = User.groupUsers(users);
        for (var entry : usersMap.entrySet()) {
            System.out.println("Возрастная группа " + entry.getKey() + " лет: ");
            for (User user : entry.getValue()) {
                System.out.println(user);
            }
            System.out.println();
        }
    }
}
