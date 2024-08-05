package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private int age;
    private String workPlace;
    private String address;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static HashMap<Integer, List<User>> groupUsers(ArrayList<User> usersList) {
        HashMap<Integer, List<User>> usersGroupedByAge = new HashMap<>();
        for (User user : usersList) {
            int userAge = user.getAge();
            if (!(usersGroupedByAge.containsKey(userAge))) {
                usersGroupedByAge.put(userAge, new ArrayList<User>());
            }
            usersGroupedByAge.get(userAge).add(user);
        }
        return usersGroupedByAge;
    }
}
