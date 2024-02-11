package faang.school.godbless;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.List;

public class Application {
    public static void main(String... args) {
        System.out.println("Hello world");
        User user1Validation = new User("vanya","Google","London",18);
        User user2Validation = new User("Petua","Amazon","Minsk",19);
        User user3Validation = new User("Misha","Google","London",17);

        List<User> users = new ArrayList<>();
        Set<String> activity1 = Set.of("Drawing", "Dancing", "Music", "Sport");
        User user1 = new User("Ivan", 14, activity1);
        Set<String> activity2 = Set.of("Dancing", "Music", "Drawing", "Sport");
        User user2 = new User("Sergey", 20, activity2);
        Set<String> activity3 = Set.of("Sport", "Drawing", "Dancing", "Music");
        User user3 = new User("Artem", 35, activity3);
        Set<String> activity4 = Set.of("Learning foreign languages", "Blogging");
        User user4 = new User("Mathew", 23, activity4);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        Map<User, String> spisUser = User.findHobbyLovers(users, activity2);
      
        int[] numbers = {1,2,3,4,5,6,7,8,9,0};
        int[] reversNum = Example.reverse(numbers);
        for (int j : reversNum) {
            System.out.print(j);
        }

    }
}
