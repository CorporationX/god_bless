package school.faang.task_43958;

import lombok.*;

import java.util.*;

@Data
@AllArgsConstructor
public class User {
    private Long id;
    private String name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return age == user.age && Objects.equals(id, user.id) && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }
}
