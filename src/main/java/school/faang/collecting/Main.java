package school.faang.collecting;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Set<String> firstHobbies = Set.of("Swimming", "Reading");
        Set<String> secondHobbies = Set.of("Jogging", "Swimming");
        Set<String> thirdHobbies = Set.of("Gaming", "Skiing");
        Set<String> fourthHobbies = Set.of("Reading", "Boxing");

        List<User> users = List.of(new User(1, "Yerasyl", 25, firstHobbies),
                new User(2, "Mger", 31, secondHobbies),
                new User(3, "Iliyas", 20, thirdHobbies),
                new User(4, "Kostya", 35, fourthHobbies)
        );
        Set<String> hobbies = new HashSet<>(Arrays.asList("Gaming", "Swimming", "Dancing", "Painting"));
        Map<User, String> hobbyLovers = User.findHobbyLovers(users, hobbies);
        for (Map.Entry<User, String> entry : hobbyLovers.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
