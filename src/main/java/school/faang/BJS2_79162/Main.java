package school.faang.BJS2_79162;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<school.faang.User> userList = new ArrayList<>();
        userList.add(new school.faang.User(1, "gena", 20, Set.of("hobby horsing", "table tennis")));
        userList.add(new school.faang.User(2, "gena2", 20, new HashSet<>(Set.of("table tennis", "volleyball"))));
        userList.add(new school.faang.User(3, "gena3", 20, new HashSet<>(Set.of("volleyball", "skate"))));
        userList.add(new school.faang.User(4, "gena4", 20, new HashSet<>(Set.of("hobby horsing"))));
        userList.add(new school.faang.User(5, "gena5", 20, new HashSet<>(Set.of("singing"))));

        Set<String> hobbies = new HashSet<>(Set.of("hobby horsing", "volleyball"));
        Map<school.faang.User, String> m = school.faang.User.findHobbyLovers(userList, hobbies);
        for (Map.Entry<User, String> entry : m.entrySet()) {
            System.out.printf("key %s %s\n", entry.getKey().getName(), entry.getValue());
        }
    }

}