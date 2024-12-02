package school.faang.task_43958;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<User> users = prepareData();
        long l = System.currentTimeMillis();
        Map<User, String> hobbyLovers = User.findHobbyLovers(users, Set.of("chess", "football"));
        System.out.println(System.currentTimeMillis() - l);
        long l1 = System.currentTimeMillis();
        Map<User, String> hobbyLovers1 = User.findHobbyLoversWhenLargeData(users, Set.of("chess", "football"));
        System.out.println(System.currentTimeMillis() - l1);
    }

    private static List<User> prepareData() {
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "Alex", 10, Set.of("football", "basketball")));
        users.add(new User(2L, "Ben", 15, Set.of("chess", "basketball")));
        users.add(new User(3L, "Jane", 21, Set.of("volleyball", "basketball")));
        users.add(new User(4L, "Jane", 21, Set.of("volleyball", "basketball")));
        users.add(new User(5L, "Jane", 21, Set.of("volleyball", "basketball")));
        users.add(new User(6L, "Jane", 21, Set.of("volleyball", "basketball")));
        users.add(new User(7L, "Jane", 21, Set.of("volleyball", "basketball")));
        users.add(new User(8L, "Jane", 21, Set.of("volleyball", "basketball")));
        users.add(new User(9L, "Jane", 21, Set.of("volleyball", "basketball")));
        users.add(new User(10L, "Jane", 21, Set.of("volleyball", "basketball")));
        users.add(new User(11L, "Jane", 21, Set.of("volleyball", "basketball")));
        users.add(new User(12L, "Jane", 21, Set.of("volleyball", "basketball")));
        users.add(new User(13L, "Jane", 21, Set.of("volleyball", "basketball")));
        users.add(new User(14L, "Jane", 21, Set.of("volleyball", "basketball")));
        users.add(new User(15L, "Jane", 21, Set.of("volleyball", "basketball")));
        users.add(new User(16L, "Jane", 21, Set.of("volleyball", "basketball")));
        users.add(new User(17L, "Jane", 21, Set.of("volleyball", "basketball")));
        users.add(new User(18L, "Jane", 21, Set.of("volleyball", "basketball")));
        users.add(new User(19L, "Jane", 21, Set.of("volleyball", "basketball")));
        users.add(new User(20L, "Jane", 21, Set.of("volleyball", "basketball")));
        users.add(new User(21L, "Jane", 21, Set.of("volleyball", "basketball")));
        users.add(new User(22L, "Jane", 21, Set.of("volleyball", "basketball")));
        users.add(new User(23L, "Jane", 21, Set.of("volleyball", "basketball")));
        users.add(new User(24L, "Jane", 21, Set.of("volleyball", "basketball")));
        users.add(new User(25L, "Jane", 21, Set.of("volleyball", "basketball")));
        users.add(new User(26L, "Jane", 21, Set.of("volleyball", "basketball")));
        users.add(new User(27L, "Jane", 21, Set.of("volleyball", "basketball")));
        users.add(new User(28L, "Jane", 21, Set.of("volleyball", "basketball")));
        users.add(new User(29L, "Jane", 21, Set.of("volleyball", "basketball")));
        users.add(new User(30L, "Jane", 21, Set.of("volleyball", "basketball")));
        users.add(new User(31L, "Jane", 21, Set.of("volleyball", "basketball")));
        users.add(new User(32L, "Jane", 21, Set.of("volleyball", "basketball")));
        users.add(new User(33L, "Jane", 21, Set.of("volleyball", "basketball")));
        users.add(new User(34L, "Jane", 21, Set.of("volleyball", "basketball")));
        users.add(new User(35L, "Jane", 21, Set.of("volleyball", "basketball")));
        users.add(new User(36L, "Jane", 21, Set.of("volleyball", "basketball")));
        users.add(new User(37L, "Jane", 21, Set.of("volleyball", "basketball")));
        users.add(new User(38L, "Jane", 21, Set.of("volleyball", "basketball")));
        users.add(new User(39L, "Jane", 21, Set.of("volleyball", "basketball")));
        users.add(new User(40L, "Jane", 21, Set.of("volleyball", "basketball")));
        users.add(new User(41L, "Jane", 21, Set.of("volleyball", "basketball")));
        users.add(new User(42L, "Jane", 21, Set.of("volleyball", "basketball")));
        users.add(new User(43L, "Jane", 21, Set.of("volleyball", "basketball")));
        users.add(new User(44L, "Jane", 21, Set.of("volleyball", "basketball")));
        return users;
    }
}
