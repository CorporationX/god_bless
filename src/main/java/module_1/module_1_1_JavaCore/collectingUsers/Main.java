package module_1.module_1_1_JavaCore.collectingUsers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("John", Set.of("football", "basketball", "programming")));
        users.add(new User("Jane", Set.of("coding", "football", "basketball")));
        users.add(new User("Alice", Set.of("walk", "cooking")));

        Set<String> hobbies = Set.of("coding", "basketball");

        Map<User, String> result = User.findHobbyLovers(users, hobbies);
        result.forEach((K, V) -> System.out.println("name: " + K.getName() + " hobby: " + V));
    }
}
