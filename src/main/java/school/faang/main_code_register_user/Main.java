package school.faang.main_code_register_user;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Gadzhi", 19, "Google", "London"),
                new User("Vlad", 19, "Uber", "New York"),
                new User("Andrey", 19, "Amazon", "Amsterdam"),
                new User("Anton", 19, "Microsoft", "Paris"),
                new User("Basiliy", 22, "Meta", "Machachkala"),
                new User("Anastasya", 22, "Sber", "Moscow"),
                new User("Petr", 40, "Yandex", "Piter")
        );

        System.out.println(User.groupUsers(users));
    }
}