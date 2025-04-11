package school.faang;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MainTest68328 {
    public static void main(String[] args) {

        List<User> people = Arrays.asList(
                new User("Emy", 18, "somewhere", "somewhere"),
                new User("Penny", 18, "somewhere", "somewhere"),
                new User("Bernadette", 19, "somewhere", "somewhere"),
                new User("Leslie Winkle", 25, "somewhere", "somewhere"));

        Map<Integer, List<User>> usersGroupedByAge = User.groupUsers(people);
        for (Map.Entry<Integer, List<User>> entry : usersGroupedByAge.entrySet()) {
            System.out.println(entry);

        }
    }
}
