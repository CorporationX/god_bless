package school.faang.bjs285552;

import java.util.ArrayList;
import java.util.List;

import static school.faang.bjs285552.User.groupUsers;

public class Main {
    private static final List<User> users = new ArrayList<>();

    public static void main(String[] args) {
        users.add(new User("Olga", 26, "companyD", "Moscow"));
        users.add(new User("Oleg", 26, "companyA", "SPB"));
        users.add(new User("Elena", 33, "companyB", "NN"));
        users.add(new User("Igor", 33, "companyC", "Kazan"));

        System.out.println( groupUsers(users));
    }
}
