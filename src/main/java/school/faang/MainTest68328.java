package school.faang;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MainTest68328 {
    public static void main(String[] args) {

        List<User68328> people = Arrays.asList(
                new User68328("Emy", 18, "somewhere", "somewhere"),
                new User68328("Penny", 18, "somewhere", "somewhere"),
                new User68328("Bernadette", 19, "somewhere", "somewhere"),
                new User68328("Leslie Winkle", 25, "somewhere", "somewhere"));

        Map<Integer, List<User68328>> usersGroupedByAge = User68328.groupUsers(people);
        for (Map.Entry<Integer, List<User68328>> entry : usersGroupedByAge.entrySet()) {
            System.out.println(entry);

        }
    }
}