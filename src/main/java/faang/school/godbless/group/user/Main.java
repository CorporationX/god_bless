package faang.school.godbless.group.user;

import lombok.NonNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NonNull
public class Main {
    public static void main(String[] args) {
        User userAlex = new User("Alex", 22, "Google", "NewYork");
        User userJoe = new User("Joe", 25, "Sony", "Los Angeles");
        User userDiana = new User("Diana", 33, "BBC", "London");
        User userBob = new User("Bob", 22, "Sony", "London");
        List<User> listOfUser = List.of(userJoe, userDiana, userAlex, userBob);
        groupUsers(listOfUser);
        showUsersGroupedByAge(listOfUser);
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> usersByAge = new HashMap<>();
        for (User user : users) {
            int keyAge = user.getAge();
            if (usersByAge.containsKey(keyAge)) {
                usersByAge.get(keyAge).add(user);
            } else {
                List<User> listByKey = List.of(user);
                usersByAge.put(keyAge, listByKey);
            }
        }
        return usersByAge;
    }

    public static void showUsersGroupedByAge(List<User> users) {
        for (Map.Entry<Integer, List<User>> user : groupUsers(users).entrySet()) {
            System.out.println(user);
        }
    }
}