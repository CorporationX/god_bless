package school.faang.group_users_by_age;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class User {
    private final String name;
    private final int age;
    private final String workplace;
    private final String address;


    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> mapSort = new TreeMap<>();
        if (users.size() == 0) {
            return null;
        } else {
            for (User user : users) {
                if (!mapSort.containsKey(user.getAge())) {
                    mapSort.put(user.getAge(),
                            new ArrayList<>());
                }
                mapSort.get(user.getAge()).add(user);
            }
        }
        return mapSort;
    }
}

