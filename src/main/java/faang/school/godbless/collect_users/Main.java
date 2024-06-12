package faang.school.godbless.collect_users;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<User> testUsers = new ArrayList<>();
        List<String> testActivities = new ArrayList<>();

        testUsers.add(new User(1, "Max", 25, new ArrayList<>(List.of("running", "swimming", "reading"))));
        testUsers.add(new User(2, "Kate", 21, new ArrayList<>(List.of("dancing", "riding a bike", "swimming"))));
        testUsers.add(new User(3, "Nik", 25, new ArrayList<>(List.of("reading", "travelling", "skiing"))));
        testUsers.add(new User(4, "Mary", 25, new ArrayList<>(List.of("baking", "walking", "reading"))));

        testActivities.add("walking");
        testActivities.add("swimming");
        testActivities.add("reading");

        System.out.println(User.findHobbyLovers(testUsers, testActivities));
    }
}

