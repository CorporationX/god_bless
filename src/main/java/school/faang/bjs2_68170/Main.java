package school.faang.bjs2_68170;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> usersList = List.of(new User("Ivan", 23, "home", "Moscow"),
                new User("Petr", 32, "office", "St.Peterburg"),
                new User("Oleg", 24, "office", "Orel"),
                new User("Alex", 32, "home", "Tver"),
                new User("Pavel", 30, "office", "Tula"),
                new User("Anna", 24, "office", "Kursk")
        );

        for (var ageGroup : User.groupUsers(usersList).entrySet()) {
            System.out.printf("Возраст: %d \n", ageGroup.getKey());
            for (User user : ageGroup.getValue()) {
                System.out.printf("%s \n", user.toString());
            }
        }
    }
}

