package faang.school.godbless.BJS2_18433;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>(Arrays.asList(
                new User("Denis", 18, "Google", "Warsaw"),
                new User("Vlad", 23, "Programmer", "Krakow"),
                new User("Danil", 23, "Waiter", "London"),
                new User("Sasha", 18, "Amazon", "London")
        ));

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
