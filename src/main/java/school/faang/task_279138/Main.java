package school.faang.task_279138;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> userList = List.of(
                new User("Pavel", 18, "Промсвязьбанк", "Загорьевская, 1"),
                new User("Jon", 19, "Промсвязьбанк", "Загорьевская, 2"),
                new User("Kate", 18, "Промсвязьбанк", "Загорьевская, 3"),
                new User("Misha", 18, "Промсвязьбанк", "Загорьевская, 4"),
                new User("Vlad", 19, "Промсвязьбанк", "Загорьевская, 5"),
                new User("Igor", 20, "Промсвязьбанк", "Загорьевская, 6"));
        System.out.println(User.groupUsers(userList).toString());
    }
}
