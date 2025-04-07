package school.faang;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User("Alex", 40, "None", "London"));
        userList.add(new User("Bob", 41, "None", "London"));
        userList.add(new User("Sam", 42, "None", "London"));
        userList.add(new User("Anna", 41, "None", "London"));
        userList.add(new User("Katya", 42, "None", "London"));
        userList.add(new User("Vanya", 42, "None", "London"));
        userList.add(new User("Kate", 41, "None", "London"));
        userList.add(new User("George", 40, "None", "London"));

        Map<Integer, List<User>> ageSorted = User.groupUsers(userList);
        System.out.println(ageSorted);
    }
}
