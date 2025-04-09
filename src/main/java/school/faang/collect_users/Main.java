package school.faang.collect_users;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Set<String> hobbies = Set.of("Dancing", "Singing", "Basketball", "Football", "Hockey", "Karate",
                "Tabletop Games", "Running", "Reading");
        List<User> list = List.of(
                new User(0, "Ivan", 20, Set.of("Basketball")),
                new User(1, "Oleg", 21, Set.of("Clubbing")),
                new User(2, "Ilya", 21, Set.of("")),
                new User(3, "Anna", 22, Set.of("Basketball", "Football", "Hockey")),
                new User(4, "Svetlana", 24, Set.of("Tabletop Games", "Running", "Reading")),
                new User(5, "Nastya", 25, Set.of("Dancing", "Singing", "Basketball", "Football")),
                new User(6, "Nikolai", 26, Set.of("Hockey", "Singing")),
                new User(7, "Sergey", 22, Set.of("Dancing", "Karate")),
                new User(8, "Jane", 23, Set.of("Reading", "Basketball"))
        );

        Map<User, String> hobbyLovers = User.findHobbyLovers(list, hobbies);
        log.info(hobbyLovers.toString());
    }
}
