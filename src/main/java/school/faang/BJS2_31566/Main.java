package school.faang.BJS2_31566;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Set<String> activities1 = new HashSet<>(Arrays.asList("Cooking", "Jellyfish catching", "Playing with friends"));
        Set<String> activities2 = new HashSet<>(Arrays.asList("Jellyfish catching", "Sleeping", "Eating"));
        Set<String> activities3 = new HashSet<>(Arrays.asList("Playing the clarinet", "Painting", "Sleeping"));

        User user1 = new User(1, "Губка Боб", 36, activities1);
        User user2 = new User(2, "Патрик", 36, activities2);
        User user3 = new User(3, "Сквидвард", 43, activities3);

        List<User> users = Arrays.asList(user1, user2, user3);
        Set<String> hobbies = new HashSet<>(Arrays.asList("Jellyfish catching", "Sleeping", "Cooking"));

        Map<User, String> hobbyLovers = User.findHobbyLovers(users, hobbies);

        for (Map.Entry<User, String> entry : hobbyLovers.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
