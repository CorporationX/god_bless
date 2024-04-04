package faang.school.godbless.BJS2_4514;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        User user1 = new User(1, "Sam", 25, List.of("Music", "Car", "Sport"));
        User user2 = new User(2, "Nick", 45, List.of("Fish", "Car", "Hunt"));
        User user3 = new User(3, "Marie", 30, List.of("Clothes", "Fashion", "Food"));

        List<User> userList = List.of(user1, user2, user3);
        List<String> listActivities = List.of("Hokey", "football", "Hunt");
        Map<User, String> out = User.findHobbyLovers(userList, listActivities);

        for (User user : out.keySet()) {
            System.out.println(user.getName() + " " + out.get(user));
        }
    }
}
