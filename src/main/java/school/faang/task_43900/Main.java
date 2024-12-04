package school.faang.task_43900;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("Alisa", 22, "Amazon", "Amsterdam"),
                new User("Cheburek", 27, "Google", "Chebarkul"),
                new User("Alabama", 22, "Uber", "Cherepovets"),
                new User("Matroskin", 18, "SpaceX", "Anapa"),
                new User("How", 27, "Rostics", "Moscow"),
                new User("Cow", 18, "Farm", "Moon")
        );

        Map<Integer, List<User>> groupUsersByAge = User.groupUsers(users);

        System.out.println(groupUsersByAge);
    }
}
