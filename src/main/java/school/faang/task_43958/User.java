package school.faang.task_43958;

import lombok.*;

import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {
    @EqualsAndHashCode.Include
    private Long id;
    @EqualsAndHashCode.Include
    private String name;
    @EqualsAndHashCode.Include
    private int age;
    private Set<String> hobbies;

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> map = new HashMap<>();
        for (User user : users) {
            for (String hobby : user.getHobbies()) {
                if (activities.contains(hobby)) {
                    map.put(user, hobby);
                    break;
                }
            }
        }
        return map;
    }

    // к сожалению мне лень создавать много данных
    // (если какой-то способ как это проверить не создавая ручками куча юзеров, скажите плз)
    // в целом думаю будет работать быстрее когда много данных так как я завязался на ключи,
    // ведь мапа быстро находит по ключам.
    public static Map<User, String> findHobbyLoversWhenLargeData(List<User> users, Set<String> activities) {
        Map<String, List<User>> hobbyToUsers = new HashMap<>();

        for (User user : users) {
            for (String hobby : user.getHobbies()) {
                hobbyToUsers.computeIfAbsent(hobby, k -> new ArrayList<>()).add(user);
            }
        }
        Map<User, String> map = new HashMap<>();
        for (String activity : activities) {
            if (hobbyToUsers.containsKey(activity)) {
                for (User user : hobbyToUsers.get(activity)) {
                    map.putIfAbsent(user, activity);
                }
            }
        }
        return map;
    }
}
