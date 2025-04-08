package school.faang.bjs2_68088;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        var max = new User(1, "Max", 19, Set.of("HobbyOne", "HobbyFour"));
        var fox = new User(2, "Fox", 20, Set.of("HobbyThree", "HobbyFour"));
        var ben = new User(3, "Ben", 21, Set.of("HobbyFive", "HobbySix"));
        var kir = new User(4, "Kir", 22, Set.of("HobbySeven", "HobbyEight"));

        var users = Set.of(max, fox, ben, kir);

        var matchingUsers = User.findHobbyLovers(users, Set.of("HobbyOne", "HobbyFour"));

        for (User user : matchingUsers.keySet()) {
            System.out.printf("%s %s\n", user.getName(), matchingUsers.get(user));
        }
    }
}
