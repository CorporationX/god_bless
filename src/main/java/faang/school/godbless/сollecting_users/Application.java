package faang.school.godbless.сollecting_users;

import java.util.List;

public class Application {
    public static void main(String... args) {
        User currentUser = new User("Artem", 23, List.of("activity1", "activity2", "activity3"));
        User user1 = new User("Nikita", 27, List.of("activity8", "activity5", "activity16"));
        User user2 = new User("Nastya", 30, List.of("activity88", "activity5", "activity3"));

        List<String> activities = List.of("activity1", "activity88", "activity16");
        User[] users = new User[]{user1, user2};

        System.out.println(currentUser.findHobbyLovers(users, activities));
    }
}
