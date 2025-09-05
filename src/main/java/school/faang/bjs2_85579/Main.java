package school.faang.bjs2_85579;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, List<User>> groupedUsersByAge = User.groupUsers(new ArrayList<>(Arrays.asList(
                new User("Andrew", 22),
                new User("Roman", 22),
                new User("Anya", 1),
                new User("Oleg", 99),
                new User("Vlad", 23),
                new User("Alisa", 1)

                )));

        for (Map.Entry<Integer, List<User>> entry : groupedUsersByAge.entrySet()) {
            System.out.print("\n---\nВозраст: " + entry.getKey() + "\nПользователи: ");
            for (User user : entry.getValue()) {
                System.out.print(user.getName() + ", ");
            }
        }

    }
}
