package school.faang.bjs2_79162;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "gena", 20, Set.of("hobby horsing", "table tennis")));
        userList.add(new User(2, "gena2", 20, Set.of("table tennis", "volleyball")));
        userList.add(new User(3, "gena3", 20, Set.of("volleyball", "skate")));
        userList.add(new User(4, "gena4", 20, Set.of("hobby horsing ")));
        userList.add(new User(5, "gena5", 20, Set.of("singing")));

        Set<String> hobbies = new HashSet<>(Set.of("hobby horsing", "volleyball"));
        Map<User, String> m = User.findHobbyLovers(userList, hobbies);
        for (Map.Entry<User, String> entry : m.entrySet()) {
            System.out.printf("key %s %s\n", entry.getKey().getName(), entry.getValue());
        }
    }

}