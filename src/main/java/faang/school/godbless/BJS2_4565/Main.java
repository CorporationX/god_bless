package faang.school.godbless.BJS2_4565;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("Ivan", 25, "Yandex", "Moscow"),
                new User("Vlad", 25, "Uber", "Los Angeles"),
                new User("Vladimir", 38, "Google", "NY"),
                new User("Luck", 91, "Amazon", "Limassol"),
                new User("Sergey", 91, "Microsoft", "San Diego")
        );

        System.out.println(User.groupUsersByAge(users));
    }
}
