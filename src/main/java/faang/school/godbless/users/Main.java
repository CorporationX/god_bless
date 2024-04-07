package faang.school.godbless.users;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        List<User> users = Arrays.asList(
                new User("Tom", 15, "Amazon", "New York"),
                new User("Jon", 11, "Google", "Atlanta"),
                new User("Ann", 23, "Uber", "Amsterdam"),
                new User("Liza", 15, "Microsoft", "Baltimore"),
                new User("Pol", 17, "Oracle", "Michigan")
        );
        Map<Integer, List<User>> groupedUsersByAge = User.groupedUsersByAge(users);
        for (Map.Entry<Integer, List<User>> entry : groupedUsersByAge.entrySet()) {
            System.out.println(entry.toString());
        }
    }
}
