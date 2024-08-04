package faang.school.godbless.BJS2_18423;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        User userOne = new User(1, "Oleg", 25, Set.of("sport", "gaming", "cinema"));
        User userTwo = new User(2, "Petr", 22, Set.of("music", "books"));
        User userThree = new User(3, "Victor", 30, Set.of("books", "auto", "photo"));
        List<User> users = List.of(userOne, userTwo, userThree);
        Map<User,String> hobbyLovers = User.findHobbyLovers(users, Set.of("books", "cinema"));
        hobbyLovers.forEach((user, activity) -> System.out.println(user + ": " + activity));
    }
}
