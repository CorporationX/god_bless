package faang.school.godbless.Denalg;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> activity1 = new HashSet<>();
        Set<String> activity2 = new HashSet<>();
        activity1.add("Football");
        activity1.add("Basketball");
        activity2.add("Tennis");
        activity2.add("Boxing");

        User user1 = new User(1, "Denis", 31, activity1);
        User user2 = new User(2, "Ivan", 20, activity2);

        Map<User, String> result = User.findHobbyLovers(Arrays.asList(user1, user2),
                new HashSet<>(Arrays.asList("Football", "Shooting")));
        System.out.println(result);
    }
}
