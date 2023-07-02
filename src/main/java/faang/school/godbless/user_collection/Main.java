package faang.school.godbless.user_collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {

    private static final Set<String> HOBBY = new HashSet<>(Arrays.asList("Music", "Sport", "Dancing", "Fishing", "Hiking"));

    public static void main(String[] args) {
        User user1 = new User(1, "Natalya", 18, new LinkedHashSet<>(Arrays.asList("Music", "Dancing", "Fishing", "Hiking")));
        User user2 = new User(2, "Engi", 32, new LinkedHashSet<>(Arrays.asList("Sport", "Dancing", "Fishing", "Hiking")));
        User user3 = new User(3, "Evgeny", 40, new LinkedHashSet<>(Arrays.asList("Eating", "Hiking", "Films")));
        User user4 = new User(4, "Anastas", 26, new LinkedHashSet<>(Arrays.asList("Sleeping", "Fishing", "Hiking", "Sport")));
        User user5 = new User(5, "Bobo", 8, new LinkedHashSet<>(Arrays.asList("Games")));
        Set<User> userSet = new HashSet<>();
        userSet.add(user1);
        userSet.add(user2);
        userSet.add(user3);
        userSet.add(user4);
        userSet.add(user5);
        System.out.println(User.findHobbyLovers(userSet, HOBBY));
    }
}
