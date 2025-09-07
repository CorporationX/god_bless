package school.faang.bjs2_85579;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> agesAndUsers = new HashMap<>();

        for (User user : users) {
            List<User> sameAgeUsers = agesAndUsers.get(user.getAge());
            if (sameAgeUsers == null) {
                sameAgeUsers = new ArrayList<>();
                agesAndUsers.put(user.getAge(), sameAgeUsers);
            }
            sameAgeUsers.add(user);
        }

        System.out.println("Содержание:   " + agesAndUsers);

        return agesAndUsers;
    }
}
