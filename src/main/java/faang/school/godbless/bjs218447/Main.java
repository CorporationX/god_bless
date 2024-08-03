package faang.school.godbless.bjs218447;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        User user = new User(1L, "Tomas", 16, Set.of("reading", "swimming", "drawing"));
        User user2 = new User(2L, "Kevin", 19, Set.of("KFC", "watching TV/Movies", "drawing"));
        User user3 = new User(3L, "John", 17, Set.of("UFC", "swimming", "boxing"));
        User user4 = new User(4L, "Kyle", 20, Set.of("StandUp", "dancing", "singing"));

        List<User> users = List.of(user, user2, user3, user4);
        Set<String> activities = Set.of("drawing", "swimming", "StandUp", "reading", "KFC", "UFC");
        System.out.println(user.findHobbyLovers(users, activities));
    }
}
