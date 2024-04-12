package task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static task1.User.groupUsers;

public class Main {
    public static void main(String[] args) {
        User Luca = new User("Luca", 17, "Google", "New York");
        User Aiden = new User("Aiden", 21, "Amazon", "London");
        User Luke = new User("Luke", 22, "Uber", "Amsterdam");
        List<User> users = new ArrayList<>();
        users.add(Luca);
        users.add(Aiden);
        users.add(Luke);
        Map<Integer, List<User>> sortedUsersMap =  groupUsers(users);
        for (Integer i : sortedUsersMap.keySet())
            System.out.println("key: " + i + " value: " + sortedUsersMap.get(i));
    }
}