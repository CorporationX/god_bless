package faang.school.godbless.task4_Sprint2;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        List<User> users = new LinkedList<>();

        users.add(new User(1, "Alex", 20, Set.of("Running")));
        users.add(new User(2, "Jon", 22, Set.of("Swimming")));
        users.add(new User(3, "Jak", 20, Set.of("Walking")));
        users.add(new User(4, "Bob", 20, Set.of("Jumping")));
        users.add(new User(5, "Mark", 22, Set.of("Fighting")));

        Set<String> inputList = Set.of("Swimming", "Running", "Walking", "Jumping");
        System.out.println(User.findHobbyLovers(users, inputList));
    }
}
