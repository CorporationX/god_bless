package faang.school.godbless.task18466;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private long id;
    private String name;
    private int age;
    private Set<String> activity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && age == user.age && name.equals(user.name) && Objects.equals(activity, user.activity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, activity);
    }

    public static Map<User, String> findHobbyLovers(List<User> list, Set<String> set){
        Map<User, String> mapActivity = new HashMap<>();
        for (User user : list) {
            for (String activity : set) {
                if (user.getActivity().contains(activity)){
                mapActivity.put(user, activity);
                    break;
                }
            }
        }
        return mapActivity;
    }
}
