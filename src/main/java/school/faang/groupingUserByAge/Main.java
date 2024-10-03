package school.faang.groupingUserByAge;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(User.groupUsers(List.of(
                new User("Sergey", 20, "Sber", "Moskva"),
                new User("Andrey", 24, "Alfa", "Novgorod"),
                new User("Alexander", 20, "Sber", "Moskva"),
                new User("Elena", 24, "Alfa", "Tver"),
                new User("Andrey", 21, "Alfa", "Novgorod"))));
    }
}
