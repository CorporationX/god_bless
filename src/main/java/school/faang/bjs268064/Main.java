package school.faang.bjs268064;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
public class Main {
    public static void main(String[] args) {

        User artur = new User("Artur", 37, Set.of("Programming", "Gaming", "Reading"));
        User jakub = new User("Jakub", 32, Set.of("Programming", "Watching Movies", "Reading"));
        User michal = new User("Michal", 30, Set.of("Cooking", "Running", "Reading"));
        User kamil = new User("Kamil", 35, Set.of("Diving", "Gaming"));

        List<User> users = List.of(artur, jakub, michal, kamil);

        Set<String> hobbies = Set.of("Programming", "Reading");

        Map<User, String> result = User.findHobbyLovers(users, hobbies);

        for (var entry : result.entrySet()) {
            log.info("{} loves {}", entry.getKey().getName(), entry.getValue());
        }
    }
}
