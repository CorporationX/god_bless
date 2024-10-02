package school.faang;

import java.util.List;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("John Doe", 33, "Google", "123 Main St"),
                new User("Jane Doe", 33, "Microsoft", "456 Oak Ave"),
                new User("Peter Pan", 33, "Apple", "789 Pine Lane"),
                new User("Alice Wonderland", 33, "Amazon", "1011 Elm Dr"),
                new User("Bob Builder", 11, "Home Depot", "1213 Maple Rd"),
                new User("Carol Singer", 23, "Spotify", "1415 Cherry Ln"),
                new User("David Painter", 23, "Home Depot", "1617 Willow St")
        );

        System.out.println(User.groupUsers(users));
    }

}
