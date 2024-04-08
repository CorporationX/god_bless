package faang.school.godbless.BJS24601;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<User> userList = getUsers();
        Set<String> hobbies = new HashSet<>(Arrays.asList("шахматы", "теннис"));

        Map<User, String> hobbyLovers = User.findHobbyLovers(userList, hobbies);

        System.out.println("Любители хобби:");
        hobbyLovers.forEach((user, hobby) ->
                System.out.println(user.getName() + " любит " + hobby));
    }

    private static List<User> getUsers() {
        Set<String> activities1 = new HashSet<>(Arrays.asList("футбол", "плавание", "теннис"));
        Set<String> activities2 = new HashSet<>(Arrays.asList("шахматы", "плавание", "бег"));
        Set<String> activities3 = new HashSet<>(Arrays.asList("волейбол", "плавание", "баскетбол"));
        User user1 = new User(1, "Иван", 25, activities1);
        User user2 = new User(2, "Мария", 30, activities2);
        User user3 = new User(3, "Петр", 20, activities3);

        return Arrays.asList(user1, user2, user3);
    }
}
