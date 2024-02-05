package faang.school.godbless.reguser;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
public class User {

    private String name;
    private int age;
    private String workplace;
    private String adress;
    private final Set<String> VALID_JOBS = new HashSet<>(Set.of("Google", "Uber", "Amazon"));
    private final Set<String> VALID_ADRESSES = new HashSet<>(Set.of("London", "New York", "Amsterdam"));

    public User(String name, int age, String workplace, String adress) {
        if ("".equals(name) || name == null
            || age < 18
            || !VALID_JOBS.contains(workplace)
            || !VALID_ADRESSES.contains(adress)) {
            throw new IllegalArgumentException();
        }

        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.adress = adress;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();
        for (var user : users) {
            int age = user.getAge();
            if (groupedUsers.get(age) == null) {
                List<User> usersList = new ArrayList<>();
                usersList.add(user);
                groupedUsers.put(age, usersList);
            }
            else {
                groupedUsers.get(age).add(user);
            }
        }
        return groupedUsers;
    }
}
