package school.faang.collection;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static school.faang.collection.User.findHobbyLovers;

public class Main {
    public static void main(String[] args) {
        Set<String> user1Activities = Set.of("Computer games", "Football", "Baseball");
        User user1 = new User(1, "Abzalkhan", 24, user1Activities);

        Set<String> user2Activities = Set.of("Swimming", "Football", "Running");
        User user2 = new User(2, "Olzhas", 24, user2Activities);

        Set<String> user3Activities = Set.of("Programming", "Films", "Baseball");
        User user3 = new User(3, "Aida", 25, user3Activities);

        Set<String> user4Activities = Set.of("Computer games", "Football", "Programming");
        User user4 = new User(4, "Nural", 27, user4Activities);

        List<User> users = Arrays.asList(user1, user2, user3, user4);
        Set<String> interests = Set.of("Computer games", "Programming", "Football");
        System.out.println(findHobbyLovers(users, interests));
    }
}
