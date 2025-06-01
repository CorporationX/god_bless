package school.faang.bjs2_79158;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public record User(String name, int age, String workplace, String address) {

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> usersByAge = new HashMap<>();

        for (User user : users) {
            usersByAge.computeIfAbsent(user.age, (age) -> new ArrayList<>()).add(user);
        }

        return  usersByAge;
    }
}
