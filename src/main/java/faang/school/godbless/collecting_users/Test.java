package faang.school.godbless.collecting_users;

import java.util.List;
import java.util.Map;
import java.util.Set;

class Test {
    public static void main(String[] args) {

        List<User> users = List.of(
                new User(1, "Bob", 21, Set.of("Act211", "Act3", "Act65")),
                new User(2, "Sam", 32, Set.of("Act14", "Act21", "Act25")),
                new User(3, "Liza", 12, Set.of("Act17", "Act378", "Act95")),
                new User(4, "Patrik", 23, Set.of("Act78", "Act23", "Act5")));

        Set<String> activities = Set.of("Act378", "Act211", "Act6ц5");

        Map<User, String> map1 = User.findHobbyLovers(users, activities);

        System.out.println(map1);
    }
}
