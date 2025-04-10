package school.faang.bjs2_68286;

import school.faang.bjs2_68286.model.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Vladislav", 28, "KEFIR", "Volgograd"),
                new User("Jeff", 54, "Amazon", "New-York"),
                new User("Anton", 28, "Google", "Sacramento"),
                new User("Veronika", 25, "MTZ", "Minsk"),
                new User("Marina", 28, "OOO Moscow", "Moscow")
        );

        System.out.println(User.groupUsers(users));
    }
}
