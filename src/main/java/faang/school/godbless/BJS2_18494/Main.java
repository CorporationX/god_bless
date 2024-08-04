package faang.school.godbless.BJS2_18494;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Denis", 18, "Student", "Warsaw"),
                new User("Vlad", 23, "Programmer", "Krakow"),
                new User("Danil", 23, "Waiter", "London"),
                new User("Sasha", 18, "Cleaner", "Moscow")
        );

        Map<Integer, List<User>> ageToUsersMap = User.groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry : ageToUsersMap.entrySet() ) {
            System.out.print(entry.getKey() + ":");
            for (User user : entry.getValue()) {
                System.out.print(" " + user.getName() + ", ");
            }
            System.out.println();
        }
    }
}
