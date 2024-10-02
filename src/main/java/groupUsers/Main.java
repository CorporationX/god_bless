package groupUsers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User("Ann", 22, "Google", "London"));
        userList.add(new User("Nastya", 19, "Sber", "Moscow"));
        userList.add(new User("Pasha", 19, "Sber", "Moscow"));
        System.out.println("USERLIST:\t" + userList);

        System.out.println();
        Map<Integer, List<User>> mapGroup = User.groupUsers(userList);
        printMap(mapGroup);

    }

    public static void printMap(Map<Integer, List<User>> map) {
        for (Map.Entry<Integer, List<User>> entry : map.entrySet()) {
            System.out.println("Age: " + entry.getKey() + "\t\tGroup: " + entry.getValue());
        }
    }
}
