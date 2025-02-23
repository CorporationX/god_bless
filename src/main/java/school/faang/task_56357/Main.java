package school.faang.task_56357;

import java.util.List;
import java.util.Map;

// Группировка пользователей по возрасту

public class Main {
    public static void main(String[] args) {

        User mike = new User("Mike", 21, "office", "Moscow");
        User jack = new User("Jack", 32, "house", "Tula");
        User sam = new User("Sam", 21, "workshop", "Sochi");
        User john = new User("John", 43, "factory", "SP");

        List<User> users = List.of(mike, jack, sam, john);

        Map<Integer, List<User>> userGroups = User.groupUsers(users);
        for (Map.Entry<Integer, List<User>> entry : userGroups.entrySet()) {
            System.out.printf("Age: %d\n", entry.getKey());
            for (User user : entry.getValue()) {
                System.out.printf("\tName: %s, Workplace: %s, Address: %s.  \n",
                        user.getUsername(), user.getWorkplace(), user.getAddress());
            }
        }
    }

}
