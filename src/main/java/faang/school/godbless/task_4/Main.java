package faang.school.godbless.task_4;

import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(1L, "Tem", 19, Set.of("football", "music"));
        User user2 = new User(2L, "Nikita", 20, Set.of("volleyball"));
        User user3 = new User(3L, "Valera", 16, Set.of("chess", "hiking"));
        User user4 = new User(4L, "Timo", 17, Set.of("cars", "football"));
        User user5 = new User(5L, "Dasha", 15, Set.of("volleyball", "music"));
        Set<User> test = Set.of(user1, user2, user3, user4, user5);
        Set<String> activities = Set.of("football", "chess");
        Map<User, String> out = User.findHobbyLovers(test, activities);
        for (User user : out.keySet()) {
            System.out.println(user.getName() + ": " + out.get(user));
        }
    }
}
