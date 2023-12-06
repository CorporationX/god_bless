package users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public static HashMap<Integer, List<User>> groupUsers (List<User> users) {
        Set<Integer> usersAgeSet = new HashSet<>();
        HashMap<Integer, List<User>> usersMap = new HashMap<>();

        for (User user : users) {
            usersAgeSet.add(user.age);
        }

        for (int currentUserAge : usersAgeSet) {
            List<User> usersOfSameAge = new ArrayList<>();

            for (User user : users) {
                if (user.age == currentUserAge) {
                    usersOfSameAge.add(user);
                }
            }

            usersMap.put(currentUserAge, usersOfSameAge);
        }

        return usersMap;
    }
}
