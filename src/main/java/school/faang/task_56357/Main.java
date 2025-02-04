package school.faang.task_56357;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Группировка пользователей по возрасту

public class Main {
    public static void main(String[] args) {

        User mike = new User("Mike", 21, "office", "Moscow");
        User jack = new User("Jack", 32, "house", "Tula");
        User sam = new User("Sam", 21, "workshop", "Sochi");
        User jon = new User("Jon", 43, "factory", "SP");

        List<User> users = new ArrayList<>();
        users.add(mike);
        users.add(jack);
        users.add(sam);
        users.add(jon);

        Map<Integer, List<User>> userGroups = User.groupUsers(users);
        for (Map.Entry<Integer, List<User>> entry : userGroups.entrySet()) {
            System.out.println("AGE : " + entry.getKey() + " User- " + entry.getValue());
        }
    }

}
