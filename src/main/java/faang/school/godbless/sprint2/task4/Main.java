package faang.school.godbless.sprint2.task4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User(123, "Mikhail", 21, Set.of("Baseball", "Basketball")));
        userList.add(new User(124, "Ivan", 22, Set.of("Cards", "Voleyball")));
        userList.add(new User(125, "Darya", 23, Set.of("Swimming", "Voleyball")));

        Map<User, String> ans = User.findHobbyLovers(userList, Set.of("Basketball", "Voleyball", "Swimming"));
        for (Map.Entry<User, String> entry : ans.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
