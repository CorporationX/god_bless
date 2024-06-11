package faang.school.godbless.collectibleUsers;

import java.util.*;

import static faang.school.godbless.collectibleUsers.User.findHobbyLovers;

public class Application {
    public static void main(String[] args) {
        List<User> userAll = new ArrayList<>();
        Set<String> manyActivities = new HashSet<>(Arrays.asList("бег", "плаванье"));
        User user1 = new User( 1, "user1", 2023, Set.of("бег", "велосипед"));
        User user2 = new User( 2, "user2", 2024, Set.of("гиря", "велосипед"));
        User user3 = new User( 3, "user3", 2023, Set.of("баскетбол", "велосипед"));

        userAll.add(user1);
        userAll.add(user2);
        userAll.add(user3);

        HashMap<User, String> hooby= findHobbyLovers(userAll, manyActivities);
        hooby.forEach((user, manyActive) -> {
            System.out.println("ФИО: " + user.getName() + ", активность: " + manyActive);
        });
       System.out.println();
    }
}