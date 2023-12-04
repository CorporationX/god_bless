package faang.school.godbless;

import lombok.Data;

import java.util.*;

@Data
public class User {
    private String userName;
    private int userAge;
    private String userPlaceWork;
    private String userAddress;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUser= new HashMap<>();

        for (User user: users) {
            int age = user.getUserAge();

            if(!groupedUser.containsKey(age)) {
                groupedUser.put(age, new ArrayList<>());
            }

            groupedUser.get(age).add(user);
        }

        return groupedUser;
    }
}
