package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@AllArgsConstructor
@Getter
public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    public static void main(String[] args) {
        User user = new User("den", 24, "Cur", "Tol");
        User user1 = new User("den", 30, "Cur", "Tol");

        List<User> arrayList = new ArrayList<>();
        arrayList.add(user);
        arrayList.add(user1);

        groupUsers(arrayList);
    }

    public static Map<Integer, List<User>>  groupUsers(List<User> users) {
        Map<Integer, List<User>> map = new HashMap<>();
        for (User user : users) {
            int age = user.getAge();
            if (map.containsKey(age)) {
                map.get(age).add(user);
            } else {
                List<User> groupUsers = new ArrayList<>();
                groupUsers.add(user);
                map.put(age, groupUsers);
                //map.computeIfAbsent(); еще разбираюсь
            }
        }
        return map;

    }
}