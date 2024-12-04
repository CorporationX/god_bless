package school.faang.task_43919;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        Map<Integer, List<User>> groupUsers = new HashMap<>();
        addUsersToList(users);
        //groupUsers = groupUsers(users);
        System.out.println(groupUsers);
    }
    private static void addUsersToList(List<User> users) {
        users.add(new User("Oleg", 19, "Gas station", "Surgut, Lenin street"));
        users.add(new User("Aleksandr", 19, "Gas station", "Surgut, Lenin street"));
        users.add(new User("Andrew", 19, "Mvideo", "Surgut, Pushkin street"));
        users.add(new User("Svetlana", 23, "Theatre", "Surgut, Pushkin street"));
        users.add(new User("Mila", 18, "Theatre", "Surgut, Pushkin street"));
    }
}
