package school.faang.sprint1.task_BJS2_56315;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        User petya = new User("Petya", 23, "zavod", "msk");
        User andrey = new User("Andrey", 22, "developer", "spb");
        User kolya = new User("Kolya", 53, "devops", "Kaliningrad");

        List<User> users = List.of(petya, andrey, kolya);
        System.out.println(User.groupUsers(users));
    }
}
