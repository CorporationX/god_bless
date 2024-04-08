package faang.school.godbless.collecting_users;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        User user1 = new User(1, "Dan", 31, new HashSet<>(Arrays.asList("Running", "Swimming")));
        User user2 = new User(2, "Max", 29, new HashSet<>(Arrays.asList("Sleeping", "Hiking")));
        User user3 = new User(3, "Bill", 47, new HashSet<>(Arrays.asList("Swimming", "Jumping")));

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        Set<String> setOfHobbies = new HashSet<>(Arrays.asList("Playing", "Swimming"));

        Map<User, String> hobbyLovers = User.findHobbyLovers(userList, setOfHobbies);

        System.out.println("Hobby Lovers:");
        for (Map.Entry<User, String> entry : hobbyLovers.entrySet()) {
            System.out.println(entry.getKey().getName()+ " loves " + entry.getValue());
        }
    }
}
