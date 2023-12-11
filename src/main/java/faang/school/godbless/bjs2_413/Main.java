package faang.school.godbless.bjs2_413;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Anton", 23, "Google", "London");
        User user2 = new User("Roma", 44,"Yandex", "Moscow");
        User user3 = new User("Igor", 16, "Uber", "Amsterdam");
        User user4 = new User("Maks", 19, "Amazon", "New York");
        User user5 = new User("Anton", 23, "Google", "London");
        User user6 = new User("Anton", 33, "Uber", "Sochi");

        List<User> users = List.of(user1, user2, user3, user4);


        Map<Integer, List<User>> groupAge = User.groupUsers(users);
        for (Map.Entry<Integer, List<User>> entry : groupAge.entrySet()) {
            System.out.print(entry.getKey() + " - ");
            for (User user : entry.getValue()) {
                System.out.print(user.getName() + " ");
            }
            System.out.println("\n");
        }
    }
}
