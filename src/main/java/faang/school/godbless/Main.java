package faang.school.godbless;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user = new User("Vlad", 26, "Java developer", "Amsterdam");
        User user1 = new User("Gor", 32, "Trainee developer", "Moscow");
        User user2 = new User("Rik", 35, "Trainee developer", "Yekaterinburg");
        User user3 = new User("Anton", 21, "Java developer", "Saint Peterburg");

        List<User>users = List.of(user, user1, user2, user3);

        System.out.println(User.groupUsers(users));
    }
}
