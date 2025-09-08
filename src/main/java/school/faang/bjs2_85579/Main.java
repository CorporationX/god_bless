package school.faang.bjs2_85579;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, List<User>> groupedUsersByAge = User.groupUsers(List.of(
                new User("Andrew", 22, "workplace", "address"),
                new User("Roman", 22, "workplace", "address"),
                new User("Anya", 1, "workplace", "address"),
                new User("Oleg", 99, "workplace", "address"),
                new User("Vlad", 23, "workplace", "address"),
                new User("Alisa", 1, "workplace", "address")

                ));

        for (Map.Entry<Integer, List<User>> entry : groupedUsersByAge.entrySet()) {
            System.out.print("\n---\nВозраст: " + entry.getKey() + "\nПользователи: ");
            for (User user : entry.getValue()) {
                System.out.print(user.getName() + ", ");
            }
        }

    }
}
