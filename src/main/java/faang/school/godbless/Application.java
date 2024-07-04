package faang.school.godbless;

import GroupingUsersByAge.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static Map<Integer, List<User>> grouping(List<User> users) {
        Map<Integer, List<User>> usersMap = new HashMap<>();
        for (User user : users) {
            int userAge = user.getAge();
            if (usersMap.containsKey(userAge)) {
                List<User> array = usersMap.get(userAge);
                array.add(user);
                usersMap.put(userAge, array);
            } else {
                List<User> newUser = new ArrayList<>();
                newUser.add(user);
                usersMap.put(userAge, newUser);
            }
        }
        return usersMap;
    }


    public static void main(String[] args) {
        User user1 = new User("Bob", "police", " Lenina", 36);
        User user2 = new User("Pit", "bilder", " Kirova", 36);
        User user3 = new User("Met", "trener", " Sverdlova", 23);
        User user4 = new User("Kail", "student", "Kurchatova", 23);
        User user5 = new User("Nail", "buhgalter", "Lenina", 56);

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);

        Map<Integer, List<User>> groupedUsers = grouping(users);
        System.out.println(groupedUsers);
    }
}