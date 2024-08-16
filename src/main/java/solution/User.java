package solution;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class User {
    private String name;
    private int age;
    private String placeOfWork;
    private String address;

    public static Map<Integer, ArrayList> groupUsers(List<User> newUsers) {
        Map<Integer, ArrayList> ageGroup = new HashMap<>();

        for (User user : newUsers) {
            int age = user.getAge();
            ageGroup.putIfAbsent(age, new ArrayList<>());
            ageGroup.get(age).add(user);
        }
        return ageGroup;
    }

}





