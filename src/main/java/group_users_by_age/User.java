package group_users_by_age;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public record User(String name, int age, String placeOfWork, String address) {
    public static Map<Integer, List<User>> groupUser(List<User> users) {
        Map<Integer, List<User>> groupedMapByAge = new HashMap<>();

        for (User user : users) {
            int age = user.age();
            groupedMapByAge.computeIfAbsent(age, k -> new ArrayList<>()).add(user);
        }

        return groupedMapByAge;
    }
}
