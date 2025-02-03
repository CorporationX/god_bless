package school.faang.sprint1.task_BJS2_56315;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Petya", 23, "zavod", "msk"),
                new User("Andrey", 22, "developer", "spb"),
                new User("Kolya", 53, "devops", "Kaliningrad")
                );
        System.out.println(User.groupUsers(users));
    }
}
