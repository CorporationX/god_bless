package faang.school.godbless.BJS2_4514;

import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        User user1 = new User(1, "Sam", 25, Set.of("Music", "Car", "Sport"));
        User user2 = new User(2, "Nick", 45, Set.of("Fish", "Car", "Hunt"));
        User user3 = new User(3, "Marie", 30, Set.of("Clothes", "Fashion", "Food"));

        Set<User> users = Set.of(user1, user2, user3);
        Set<String> activities = Set.of("Hokey", "football", "Hunt");
        Map<User, String> out = User.findHobbyLovers(users, activities);

        for (User user : out.keySet()) {
            System.out.println(user.getName() + " " + out.get(user));
        }
    }
}
