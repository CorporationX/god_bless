package faang.school.godbless.BJS2_7164;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
@Getter
@ToString
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> hobbies;

    public static Map<User, String> findHobbyLovers(List<User> userList, Set<String> hobbiesSet) {
        Map<User, String> collectionOfUsersByHobby = new HashMap<>();
        for (User user : userList) {
            for (String hobby : hobbiesSet) {
                if (user.hobbies.contains(hobby)) {
                    collectionOfUsersByHobby.put(user, hobby);
                    break;
                }
            }
        }

        return collectionOfUsersByHobby;
    }


    public static void main(String[] args) {
        Set<String> hobbies = Set.of("tennis", "sport", "music");

        Map<User, String> result = findHobbyLovers(List.of(new User(1, "test", 3, Set.of("play", "game")),
                new User(3, "test3", 4, Set.of("mouse", "music")),
                new User(4, "test4", 6, Set.of("water", "111")),
                new User(5, "test5", 12, Set.of("sport", "dance"))), hobbies);

        result.forEach((key, value) -> System.out.println("Ключ: " + key + " - Значение:" + value));

    }
}
