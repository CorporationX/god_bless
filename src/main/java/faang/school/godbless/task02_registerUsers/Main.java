package faang.school.godbless.task02_registerUsers;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Oleg", 17, "homeless", "London"));
        users.add(new User("Gleb", 20, "Google", "New York"));
        users.add(new User("Kirill", 40, "Microsoft", "St. Peterburg"));
        users.add(new User("Nadya", 20, "SpaceX", "Rom"));
    }
}
