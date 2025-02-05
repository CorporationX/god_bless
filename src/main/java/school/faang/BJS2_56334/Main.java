package school.faang.BJS2_56334;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Set<String> hobbies = Set.of("coding", "swimming");
        printResult(User.findHobbyLovers(createUsers(), hobbies));
    }

    public static List<User> createUsers() {

        User user1 = new User(1, "Hayotbek", 15, Set.of("runing", "swimming", "coding"));
        User user2 = new User(2, "Artur", 18, Set.of("runing", "playing computer"));
        User user3 = new User(3, "Fedya", 32, Set.of("Whatching Tv", "swimming"));

        List<User> users = List.of(user1, user2, user3);

        return users;
    }

    public static void printResult(Map<User, String> users) {
        for (Map.Entry<User, String> user : users.entrySet()) {
            System.out.println(user.getKey().getName() + "Найден навык :" + user.getValue());
        }
    }
}
