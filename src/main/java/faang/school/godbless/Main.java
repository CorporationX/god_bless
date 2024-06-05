package faang.school.godbless;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(new User("Dima", 24, "Test", "Test"),
                new User("Dima", 24, "Test", "Test"),
                new User("Maks", 10, "Test", "Test"),
                new User("Oly", 36, "Test", "Test"));
        Map<Integer, List<User>> maps = User.convertListUserToMap(users);
        for (Map.Entry<Integer, List<User>> map:maps.entrySet()) {
            System.out.println(map.getKey() + " - " + map.getValue());
        }
    }
}
