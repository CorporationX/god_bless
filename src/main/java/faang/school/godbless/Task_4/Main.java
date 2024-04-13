package faang.school.godbless.Task_4;

import java.util.*;

import static faang.school.godbless.Task_4.User.findHobbyLovers;

public class Main {
    public static void main(String[] args) {

        User user1 = new User(1, "John", 22, new HashSet<>(Arrays.asList("Fitness", "Cooking")));
        User user2 = new User(2, "Clare", 33, new HashSet<>(Arrays.asList("Gaming", "Programming")));
        User user3 = new User(3, "Rich", 44, new HashSet<>(Arrays.asList("Work", "Design")));

        List<User> users = new ArrayList<>(Arrays.asList(user1, user2, user3));

        Set<String> activities = new HashSet<>(Arrays.asList("Cooking", "Walking", "Design"));

        System.out.println(findHobbyLovers(users, activities));

    }
}
