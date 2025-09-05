package school.faang.BJS2_85629;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    String name;
    int age;
    String job;
    String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> ageBrackets = new HashMap<>();
        if (users != null) {
            for (User user : users) {
                if (ageBrackets.containsKey(user.age)) {
                    ageBrackets.get(user.age).add(user);
                } else {
                    List<User> peers = new ArrayList<>();
                    peers.add(user);
                    ageBrackets.put(user.age, peers);
                }
            }
        }
        return ageBrackets;
    }
}
