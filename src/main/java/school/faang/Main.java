package school.faang;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> userList = List.of(
                new User("Dmitriy", 24, "Spirit", "Russia"),
                new User("Justinas", 25, "Natus Vincere", "Lithuania"),
                new User("Finn", 34, "FaZe", "Denmark"),
                new User("Robin", 25, "Vitality", "Estonia"),
                new User("Rodion", 24, "Fnatic", "Ukraine")
        );

        System.out.println(User.groupUsers(userList));
    }
}