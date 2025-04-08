package school.faang.bjs2_68088;

import java.util.ArrayList;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        var max = new User(1, "Max", 19, new ArrayList<String>(Set.of("HobbyOne", "HobbyFour")));
        var fox = new User(2, "Fox", 20, new ArrayList<String>(Set.of("HobbyThree", "HobbyFour")));
        var ben = new User(3, "Ben", 21, new ArrayList<String>(Set.of("HobbyFive", "HobbySix")));
        var kir = new User(4, "Kir", 22, new ArrayList<String>(Set.of("HobbySeven", "HobbyEight")));

        var users = new ArrayList<User>(Set.of(max, fox, ben, kir));

        var matchingUsers = User.findHobbyLovers(users, new ArrayList<String>(Set.of("HobbyOne", "HobbyFour")));

        for (User user : matchingUsers.keySet()) {
            System.out.println(user.getName() + " " + matchingUsers.get(user));
        }
    }
}
