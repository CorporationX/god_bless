package user.collect;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(1, "Vitya", 24, Set.of("Fitness", "Reading"));
        User user2 = new User(2, "Vika", 21,Set.of("Kayaking", "Drawing"));
        User user3 = new User(3, "Dimas", 30, Set.of("Writing", "Gardening"));
        List<User> users = List.of(user1, user2, user3);
        System.out.println("Users:");
        for (User user : users) {
            System.out.println(user);
        }

        Set<String> activities = Set.of("Fitness", "Drawing");
        System.out.println("Activities:");
        for (String activity : activities) {
            System.out.println(activity);
        }

        System.out.println("Hobby map:");
        var hobbyMap = User.findHobbyLovers(users, activities);
        for (Map.Entry<User, String> entry : hobbyMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
