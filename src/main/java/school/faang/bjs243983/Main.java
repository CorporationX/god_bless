package school.faang.bjs243983;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<User> users = new HashSet<>();
        Random random = new Random();
        String[] names = {"Solih", "John", "Steve", "Artom"};
        List<Set<String>> availableActivities = List.of(
                Set.of("IT", "CS2", "Book"),
                Set.of("Football", "Dota", "Book"),
                Set.of("Music", "Chef", "Play"),
                Set.of("IT", "CS2", "Movie")
        );

        for (long i = 1; i < 10; i++) {
            int age = random.nextInt(10, 100);
            int index = random.nextInt(0, 4);
            User user = new User(i, names[index], age, availableActivities.get(index));
            users.add(user);
        }

        Set<String> activities = Set.of("IT", "CS2", "Book");
        User user = new User();
        Map<User, String> result = user.findHobbyLovers(users, activities);

        result.forEach((myUser, myActivity) -> {
            System.out.println(myUser.getName() + " : " + myActivity);
        });
    }
}
