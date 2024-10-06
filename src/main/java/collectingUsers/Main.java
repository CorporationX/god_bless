package collectingUsers;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> user1Activities = new HashSet<>(Arrays.asList("football", "programming", "reading"));
        User user1 = new User(1, "Ivan", 25, user1Activities);

        Set<String> user2Activities = new HashSet<>(Arrays.asList("running", "drawing", "football"));
        User user2 = new User(2, "Olga", 30, user2Activities);

        Set<String> user3Activities = new HashSet<>(Arrays.asList("programming", "chess", "swimming"));
        User user3 = new User(3, "Alex", 35, user3Activities);

        List<User> users = Arrays.asList(user1, user2, user3);

        Set<String> interestsToFind = new HashSet<>(Arrays.asList("football", "programming"));

        Map<User, String> hobbyLovers = User.findHobbyLovers(users, interestsToFind);

        System.out.println("Users with specified hobbies:");
        hobbyLovers.forEach((user, activity) ->
                System.out.println("Name: " + user.getName() + ", Hobby: " + activity)
        );
    }
}
