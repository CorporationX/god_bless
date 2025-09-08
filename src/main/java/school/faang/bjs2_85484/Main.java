package school.faang.bjs2_85484;

import java.util.HashSet;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User[] exampleUsers = {
                new User("Vlad", 24, new HashSet<>(Arrays.asList("programming", "football", "music"))),
                new User("Roman", 18, new HashSet<>(Arrays.asList("programming", "music"))),
                new User("Anya", 13, new HashSet<>(List.of("basketball"))),
                new User("Alisa", 54, new HashSet<>(Arrays.asList("basketball", "music"))),
                new User("Oleg", 99, new HashSet<>(Arrays.asList("travel", "drawing"))),
        };

        Map<User, String> usersAndHobbies = User.findHobbyLovers(exampleUsers,
                new HashSet<>(Arrays.asList("football", "programming")));
        for (Map.Entry<User, String> item : usersAndHobbies.entrySet()) {
            System.out.printf("Имя: %s\nОбщие хобби: %s \n---\n", item.getKey().getName(), item.getValue());
        }

    }
}
