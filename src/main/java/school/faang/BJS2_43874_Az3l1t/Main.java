package school.faang.BJS2_43874_Az3l1t;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> listOfUsers = new ArrayList<>(
                List.of(
                        new User("Norair", 23, "T1", "Moscow"),
                        new User("Ilya", 18, "Sber", "Moscow"),
                        new User("Egor", 18, "T-Bank", "Moscow"),
                        new User("Mark", 23, "MTC", "Moscow"),
                        new User("Dababy", 19, "Alpha", "Moscow"),
                        new User("The Weeknd", 19, "VTB", "Moscow"),
                        new User("No Name", 19, "VTB", "Moscow")
                )
        );

        Map<Integer, List<User>> groupedUsers = User.groupUsers(listOfUsers);
        System.out.println(groupedUsers);
    }
}
