package ru.kraiush.model.model;

import lombok.*;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    Long id;
    String name;
    int age;

    Set<String> activities= Set.of("journeys", "music", "tennis", "animals", "creeds", "rock climbing", "sailing");

    public static Map<User, String> findHobbyLovers(Set<String> set) {

        List<User> users= getUsers();

        Map<User, String> map = new HashMap();

        for (User user : users) {
            for(String elem: set) {
                for(String act: user.activities) {
                    if (act.equals(elem)) {
                        map.put(user, elem);
                        break;
                    }
                }
            }
        }
        return map;
    }

    public static List<User> getUsers() {
        User john = new User(1l, "John Lennon", 41, Set.of("music", "photo"));
        User starr = new User(2l, "Ringo Starr", 65, Set.of("creeds", "journeys"));
        User charly = new User(3l, "Charly Chaplin", 150, Set.of("rock climbing", "tennis"));
        User mary = new User(4l, "Mary Blad", 17, Set.of("sailing"));

        return Arrays.asList(john, starr, charly, mary);
    }
}
