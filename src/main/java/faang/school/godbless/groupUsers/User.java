package faang.school.godbless.groupUsers;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;

@AllArgsConstructor
@Getter
public class User {
    private String name;
    private int age;
    private String company;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> userGroups = new HashMap<>();

        Set<Integer> ages = new HashSet<>();
        for (User user : users) {
            ages.add(user.getAge());
        }

        for (Integer age : ages) {
            List<User> usersWithThisAge = new LinkedList<>();
            for (User user : users){
                if (user.getAge() == age){
                    usersWithThisAge.add(user);
                }
            }
            userGroups.put(age, usersWithThisAge);
        }
        return userGroups;
    }

    public String toString(){
        return name + " (" + age + " y.o., " + company + ", " + address + ")";
    }
}
