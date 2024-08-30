package ru.kraiush.BJS2_18589;

import lombok.*;

import java.util.*;

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
    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> checkActivities) {

        Map<User, String> map = new HashMap<>();

        for (User user : users) {
            for(String activity: checkActivities) {
                for(String userActivity: user.activities) {
                    if (userActivity.equals(activity)) {
                        map.put(user, activity);
                        break;
                    }
                }
            }
        }
        return map;
    }

    public static List<User> getUsers() {
        User john = new User(1L, "John Lennon", 41, Set.of("music", "photo", "dreaming"));
        User starr = new User(2L, "Ringo Starr", 65, Set.of("creeds", "journeys"));
        User charlie = new User(3L, "Charlie Chaplin", 150, Set.of("rock climbing", "tennis"));
        User mary = new User(4L, "Mary Blad", 17, Set.of("sailing", "rock climbing"));

        return Arrays.asList(john, starr, charlie, mary);
    }
}
