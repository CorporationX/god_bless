package faang.school.godbless.BJS2_481;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        List<String> listOfActivities = List.of("Basketball", "Football", "Computer games");
        User u1 = new User(1, "Rauan", 18, List.of("Reading book", "Football"));
        User u2 = new User(2, "Artem", 20, List.of("Computer games", "Football"));
        User u3 = new User(3, "Madi", 18, List.of("Collecting"));
        User u4 = new User(4, "Fedor", 24, List.of("Basketball"));
        users.add(u1);
        users.add(u2);
        users.add(u3);
        users.add(u4);
        User.findHobbyLovers(users, listOfActivities);
    }
}
