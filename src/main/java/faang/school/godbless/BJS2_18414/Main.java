package faang.school.godbless.BJS2_18414;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("A", 19, "Yandex", "Pupsnaya"),
                new User("B", 23, "Sandex", "Pupsnaya"),
                new User("C", 5, "Gandex", "Pupsnaya"),
                new User("D", 43, "Aandex", "Pupsnaya"),
                new User("E", 31, "Landex", "Pupsnaya"),
                new User("F", 19, "Pandex", "Pupsnaya"),
                new User("F", 43, "Tandex", "Pupsnaya"));

        User.groupUsers(users).forEach((key, value) ->
                System.out.println("Возраст: " + key + ", студенты: " + value));
    }
}
