package school.faang.usercollection;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        List<User> userList = List.of(
                new User(5, "Pete", 28, Set.of(HobbyTypes.VOLLEYBALL, HobbyTypes.BASKETBALL, HobbyTypes.FOOTBALL)),
                new User(1, "Alex", 30, Set.of(HobbyTypes.BASKETBALL, HobbyTypes.RUNNING, HobbyTypes.ROLLERBLADING)),
                new User(4, "Kate", 35, Set.of(HobbyTypes.SCOOTERING, HobbyTypes.CYCLING, HobbyTypes.BASKETBALL)),
                new User(3, "Kseniya", 31, Set.of(HobbyTypes.CYCLING, HobbyTypes.VOLLEYBALL, HobbyTypes.ROLLERBLADING)),
                new User(2, "Sergey", 27, Set.of(HobbyTypes.YOGA, HobbyTypes.SCOOTERING, HobbyTypes.VOLLEYBALL))
        );

        var hHobbyLovers = User.findHobbyLovers(userList, Set.of(HobbyTypes.YOGA, HobbyTypes.CYCLING, HobbyTypes.ROLLERBLADING));

        hHobbyLovers.keySet()
                .stream()
                .sorted(Comparator.comparing(User::getId))
                .forEach(key -> {
                    System.out.print(key);
                    System.out.print(" - ");
                    System.out.println(hHobbyLovers.get(key).getName());
                });

    }
}
