package school.faang.groupingusersbyage;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> listUser = List.of(
                new User("Mikhaill", 32, "Enginer", "Moscow"),
                new User("Alina", 28, "Doctor", "St. Peterburg"),
                new User("Artem", 45, "Architect", "Yekaterinburg"),
                new User("Elizaveta", 28, "Marketing", "Kazan"),
                new User("Dima", 32, "Teacher", "Novosibirsk"));

        System.out.println(User.groupUsers(listUser));
    }
}
