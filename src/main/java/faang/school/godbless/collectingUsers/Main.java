package faang.school.godbless.collectingUsers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(1, "Mike", 18, new HashSet<>(Arrays.asList("cycling", "painting", "singing")));
        User user2 = new User(2, "Kate", 20, new HashSet<>(Arrays.asList("cycling", "swimming", "reading")));
        User user3 = new User(3, "Mary", 27, new HashSet<>(Arrays.asList("singing", "running", "dancing")));
        User user4 = new User(4, "Tom", 37, new HashSet<>(Arrays.asList("running", "skiing")));
        User user5 = new User(5, "Ben", 15, new HashSet<>(Arrays.asList("coding", "reading")));

        Map<User, String> result1 = User.findHobbyLovers(new ArrayList<>(Arrays.asList(user1, user2, user3, user4, user5)),
                new HashSet<>(Arrays.asList("painting", "singing", "cycling", "dancing")));

        Map<User, String> result2 = User.findHobbyLovers(new ArrayList<>(Arrays.asList(user1, user2, user3, user4, user5)),
                new HashSet<>(Arrays.asList("coding", "painting")));

        //Mike, Kate, Mary
        for (Map.Entry<User, String> entry : result1.entrySet()) {
            System.out.println(entry.getKey().getName() + " " + entry.getValue());
        }

        System.out.println();

        //Mike, Ben
        for (Map.Entry<User, String> entry : result2.entrySet()) {
            System.out.println(entry.getKey().getName() + " " + entry.getValue());
        }
    }
}
