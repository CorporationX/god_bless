package faang.school.godbless.CollectingUsers;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> set1 = Set.of("прес качат", "атжуманя", "бегит");
        User user1 = new User(1, "a", 1, set1);
        Set<String> set2 = Set.of("плакат", "галаса в галаве", "грусные мысли");
        User user2 = new User(2, "b", 2, set2);
        List<User> users = List.of(user1, user2);
        Set<String> activities = Set.of("шашлык", "галаса в галаве", "бегит");
        System.out.println(User.findHobbyLovers(users, activities));
    }
}
