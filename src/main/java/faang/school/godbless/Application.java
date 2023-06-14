package faang.school.godbless;

import java.util.List;

public class Application {
    public static void main(String... args) {
        User currentUser = User.create("Ivan", 32, List.of("activity1", "activity2", "activity3"));
        User user1 = User.create("Semen", 58, List.of("activity8", "activity5", "activity16"));
        User user2 = User.create("Egor", 33, List.of("activity88", "activity5", "activity3"));

        List<String> activities = List.of("activity1", "activity88", "activity16");
        User[] users = new User[]{user1, user2};

        System.out.println(currentUser.findHobbyLovers(users, activities));
    }
}
