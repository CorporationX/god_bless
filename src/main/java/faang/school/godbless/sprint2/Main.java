package faang.school.godbless.sprint2;

import java.util.*;

public class Main {
    private static final Set<String> HOBBY = new HashSet<>(Arrays.asList("Music", "Sport", "Dancing", "Games", "Pole dance"));

    public static void main(String[] args) {
        User user1 = new User(1, 18, "Vlad", new LinkedHashSet<>(Arrays.asList("Sleeping", "Dancing", "Games", "Pole dance")));
        User user2 = new User(2, 32, "Misha",new LinkedHashSet<>(Arrays.asList("Sport", "Dancing", "Games", "Pole dance")));
        User user3 = new User(3, 40, "Pasha",new LinkedHashSet<>(Arrays.asList("Netflix", "Pole dance")));
        User user4 = new User(4, 26, "Zhenia", new LinkedHashSet<>(Arrays.asList("Music", "Games", "Pole dance")));
        User user5 = new User(5, 8, "Vitalii", new LinkedHashSet<>(Arrays.asList("Fishing")));
        List<User> userSet = new ArrayList<>();
        userSet.add(user1);
        userSet.add(user2);
        userSet.add(user3);
        userSet.add(user4);
        userSet.add(user5);
        System.out.println(User.findHobbyLovers(userSet, HOBBY));
    }
}