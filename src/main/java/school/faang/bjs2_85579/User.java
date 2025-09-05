package school.faang.bjs2_85579;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

import lombok.Getter;

@Getter
public class User {
    private String name;
    private int age;
    private String workAddress;
    private String homeAddress;

    User(String name, int age) {
        this.name = name;
        this.age = age;
        this.workAddress = "Lorem Ipsum";
        this.homeAddress = "Lorem Ipsum";
    }

    public static Map<Integer, List<User>> groupUsers(ArrayList<User> users) {
        Map<Integer, List<User>> agesAndUsers = new HashMap<>();
        Set<Integer> userAges = new HashSet<>();
        for (User user : users) {
            userAges.add(user.getAge());
        }
        for (int age :  userAges) {
            ArrayList<User> sameAgeUsers = new ArrayList<>(users);
            sameAgeUsers.removeIf(user -> user.getAge() != age);
            agesAndUsers.put(age, sameAgeUsers);
        }

        return agesAndUsers;
    }
}
