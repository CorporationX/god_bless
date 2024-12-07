package school.faang.s12task43996;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static school.faang.s12task43996.User.findHobbyLovers;

public class Main {
    public static void main(String[] args) {

        List<User> users = Arrays.asList(
                new User(1, "Bob", 32, Set.of("programming", "playing")),
                new User(2, "Chen", 36, Set.of("swimming", "reading")));

        Set<String> hobbies = Set.of("swimming", "reading", "programming");

        Map<User, String> usersHobbies = findHobbyLovers(users, hobbies);

        for (Map.Entry<User, String> entry : usersHobbies.entrySet()) {
            System.out.println(entry.getKey().getName() + "'s hobbies: " + entry.getValue());
        }
    }
}