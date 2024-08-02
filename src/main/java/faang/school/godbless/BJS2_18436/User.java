package faang.school.godbless.BJS2_18436;

import lombok.Data;

import java.util.*;

@Data
public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> ageOfUsers = new HashMap<>();
        Set<Integer> ages = new HashSet<>();
        for (User user : users) {
            ages.add(user.getAge());
        }
        for (Integer age : ages) {
            List<User> usersWithSameAge = new ArrayList<>();
            for (User user : usersWithSameAge) {
                if (user.getAge() == age) {
                    usersWithSameAge.add(user);
                }
            }
            ageOfUsers.put(age, usersWithSameAge);
        }
        return ageOfUsers;
    }
}
