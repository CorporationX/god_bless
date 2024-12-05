package school.faang.sprint1.task_43964;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Anna", 22, "office", "Kazan"),
                new User("Sasha", 30, "IT", "Moscow"),
                new User("Vania", 18, "depo", "Ivanovo"),
                new User("Peter", 22, "cafe", "Berlin"),
                new User("Vasia", 22, "office", "Chicago")
        );

        System.out.println(User.groupUsers(users));
    }
}