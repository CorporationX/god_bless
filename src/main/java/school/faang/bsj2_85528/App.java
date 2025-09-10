package school.faang.bsj2_85528;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class App {

    public static void main(String[] args) {
        final Set<String> activities = new HashSet<>(Arrays.asList("football", "swimming", "tennis"));

        final User userWithAllMatches = new User(1, "Vasya", 33, activities);
        final User userWithoutActivities = new User(2, "Anton", 24, new HashSet<>());
        final User userWithOneMatch = new User(3, "Ivan", 41,
                new HashSet<>(Arrays.asList("baseball", "boxing", "swimming")));
        final User userWithoutMatches = new User(3, "Olga", 21,
                new HashSet<>(Arrays.asList("dancing", "singing")));

        final Map<User, String> hobbyLovers
                = User.findHobbyLovers(new ArrayList<>(Arrays.asList(userWithAllMatches, userWithoutActivities,
                userWithOneMatch, userWithoutMatches)), activities);

        final Map<User, String> hobbyLoversWithEmptyUsersAndActivities =
                User.findHobbyLovers(new ArrayList<>(), new HashSet<>());

        final Map<User, String> hobbyLoversWithEmptyActivities =
                User.findHobbyLovers(new ArrayList<>(Arrays.asList(userWithAllMatches)), new HashSet<>());

        final Map<User, String> hobbyLoversWithEmptyUsers = User.findHobbyLovers(new ArrayList<>(), activities);

        System.out.println(hobbyLovers);
        System.out.println(hobbyLoversWithEmptyUsersAndActivities);
        System.out.println(hobbyLoversWithEmptyActivities);
        System.out.println(hobbyLoversWithEmptyUsers);
    }
}