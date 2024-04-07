package GroupingUsers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

    private String name;
    private int age;
    private String workPlace;
    private String adress;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> usersList) {
        Map<Integer, List<User>> mapUsers = new HashMap<>();

        List<User> filterUsersList = new ArrayList<>();
        for (User user : usersList) {
            if (mapUsers.containsKey(user.age)) {
                filterUsersList = mapUsers.get(user.age);
                filterUsersList.add(user);
                mapUsers.put(user.age, filterUsersList);
            } else {
                mapUsers.put(user.age, new ArrayList<>(Collections.singletonList(user)));
            }

        }

        return mapUsers;
    }

}
