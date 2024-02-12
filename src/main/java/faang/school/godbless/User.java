package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Data
public class User {
    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        list.add(new User("Bob", 23, "Work", "Home"));
        list.add(new User("Bill", 22, "Work", "Home"));
        list.add(new User("Alice", 22, "Work", "Home"));
        list.add(new User("Sara", 21, "Work", "Home"));
        System.out.println(User.groupUsers(list));
    }

    @NonNull
    private String name;
    @NonNull
    private Integer age;
    @NonNull
    private String job;
    @NonNull
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> list) {
        Map<Integer, List<User>> map = new HashMap<>();
        for (User u : list) {
            if (!map.containsKey(u.getAge())) {
                map.put(u.getAge(), new ArrayList<User>());
            }
            map.get(u.getAge()).add(u);
        }
        return map;
    }
}
