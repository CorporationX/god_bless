import faang.school.godbless.groupUsers.model.User;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        var users = List.of(new User(1, "John", 23, Set.of("swimming", "games")),
                new User(2, "Alex", 25, Set.of("swimming", "cooking")),
                new User(3, "Marty", 18, Set.of("boxing", "swimming")),
                new User(4, "Gloria", 18, Set.of("reading", "cooking")));
        var map = User.findHobbyLovers(users, Set.of("swimming", "cooking"));
        System.out.println(map);
    }
}
