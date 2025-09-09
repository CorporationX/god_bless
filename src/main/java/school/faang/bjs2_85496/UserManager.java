package school.faang.bjs2_85496;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class UserManager {
    static Random random = new Random();
    static final int USER_COUNT = 5;

    public static List<User> fillUsers(int numberOfUsers) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < numberOfUsers; i++) {
            users.add(i, new User("User" + (i + 1),
                    random.nextInt(15, 18),
                    "jobLocation" + (i + 1),
                    "address" + (i + 1)));
        }
        return users;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> usersMap = new HashMap<>();
        for (User user : users) {
            usersMap.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user);
        }
        return usersMap;
    }

    public static void displayGroupedUsers(Map<Integer, List<User>> groupedUsers) {
        for (Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()) {
            System.out.println("Возраст " + entry.getKey() + ":");
            for (User user : entry.getValue()) {
                System.out.println("\t" + user);
            }
        }
    }

    public static void main(String[] args) {
        List<User> users = fillUsers(USER_COUNT);
        Map<Integer, List<User>> groupedUsers = groupUsers(users);
        displayGroupedUsers(groupedUsers);
    }
}